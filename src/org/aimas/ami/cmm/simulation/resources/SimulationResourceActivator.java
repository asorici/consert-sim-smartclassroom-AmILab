package org.aimas.ami.cmm.simulation.resources;

import java.util.Dictionary;
import java.util.Hashtable;

import org.aimas.ami.contextrep.engine.api.InsertionHandler;
import org.aimas.ami.contextrep.resources.CMMConstants;
import org.aimas.ami.contextrep.utils.BundleResourceManager;
import org.aimas.ami.contextrep.utils.ContextModelLoader;
import org.aimas.ami.contextrep.utils.ResourceManager;
import org.aimas.ami.contextrep.vocabulary.ConsertCore;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.sparql.core.Quad;
import com.hp.hpl.jena.sparql.modify.request.QuadDataAcc;
import com.hp.hpl.jena.sparql.modify.request.UpdateDataInsert;
import com.hp.hpl.jena.update.UpdateRequest;
import com.hp.hpl.jena.vocabulary.RDF;

public class SimulationResourceActivator implements BundleActivator {
	public static final String BOOTSTRAP_FILE_URI = "http://pervasive.semanticweb.org/ont/2014/07/smartclassroom/bootstrap"; 
	
	@Override
	public void start(BundleContext context) throws Exception {
		// All we do is register the SystemTimeService with a property stating that it is intended for
		// the CMM deployment of the application with `applicationId'
		
		// All CMM Resource bundles MUST have a CONSERT_APPLICATION_HEADER with the applicationId 
		// for which the CMMdeployment configuration is specified
		Dictionary<String, String> headers = context.getBundle().getHeaders();
		String applicationId = headers.get(CMMConstants.CONSERT_APPLICATION_ID_HEADER);
		
		if (applicationId != null) {
			Dictionary<String, String> timeServiceProps = new Hashtable<String, String>();
			timeServiceProps.put(CMMConstants.CONSERT_APPLICATION_ID_PROP, applicationId);
			
			// register the SystemTimeService implementation of the TimeService
			//context.registerService(TimeService.class, new SystemTimeService(), timeServiceProps);
		}
		
		// We use this bundle activator to load the bootstrapped data into the CONSERT Engine.
		// Basically, we create a tracker and when it finds the InsertionHandler, it inserts the
		// room structure as an EntityDescription update.
		loadBootstrappedData(context);
	}
	
	private void loadBootstrappedData(final BundleContext bundleContext) throws Exception {
		// First find the bootstrapped data
		ResourceManager resourceManager = new BundleResourceManager(bundleContext.getBundle());
		ContextModelLoader contextModelLoader = new ContextModelLoader(resourceManager, null);
		final OntModel bootstrapModel = contextModelLoader.load(BOOTSTRAP_FILE_URI);
		
		// Then setup the InsertionHandler service tracker
		String engineServiceFilterStr = 
				"(&" 	
				+ "(" + Constants.OBJECTCLASS + "=" + InsertionHandler.class.getName() + ")"
				+ "(" + CMMConstants.CONSERT_APPLICATION_ID_PROP + "=" + "SmartClassroom" + ")" + ")";
		
		try {
	        Filter engineServiceFilter = bundleContext.createFilter(engineServiceFilterStr);
	        ServiceTracker<InsertionHandler, InsertionHandler> engineServiceTracker 
		    	= new ServiceTracker<InsertionHandler, InsertionHandler>(bundleContext, engineServiceFilter, 
		    			new ServiceTrackerCustomizer<InsertionHandler, InsertionHandler>() {

							@Override
                            public InsertionHandler addingService(ServiceReference<InsertionHandler> reference) {
	                            InsertionHandler insertionHandler = bundleContext.getService(reference);
	                            
	                            UpdateRequest bootstrapUpdate = new UpdateRequest();
	                    		Node entityStoreNode = Node.createURI(ConsertCore.ENTITY_STORE_URI);
	                    		
	                    		// == STEP 1: location entities
	                    		Model locationModel = ModelFactory.createDefaultModel();
	                    		
	                    		StmtIterator roomSectionStmts = bootstrapModel.listStatements(null, RDF.type, SmartClassroom.RoomSection);
	                    		StmtIterator roomStmts = bootstrapModel.listStatements(null, RDF.type, SmartClassroom.MultiFunctionalRoom);
	                    		
	                    		locationModel.add(roomSectionStmts.toList());
	                    		locationModel.add(roomStmts.toList());
	                    		locationModel.add(bootstrapModel.listStatements(null, RDF.type, SmartClassroom.SchoolBuilding));
	                    		
	                    		StmtIterator subsumedStmts = bootstrapModel.listStatements(null, SmartClassroom.spatiallySubsumedBy, (RDFNode)null);
	                    		locationModel.add(subsumedStmts.toList());
	                    		
	                    		// == STEP 2: create the EntityStore update
	                    		QuadDataAcc entityStoreData = new QuadDataAcc();
	                    		StmtIterator it = locationModel.listStatements();
	                        	for (;it.hasNext();) {
	                        		Statement s = it.next();
	                        		entityStoreData.addQuad(Quad.create(entityStoreNode, s.asTriple()));
	                        	}
	                        	
	                        	bootstrapUpdate.add(new UpdateDataInsert(entityStoreData));
	                            insertionHandler.updateEntityDescriptions(bootstrapUpdate);
	                        	
	                            return insertionHandler;
                            }

							@Override
                            public void modifiedService(ServiceReference<InsertionHandler> reference, 
                            		InsertionHandler service) {}

							@Override
                            public void removedService(ServiceReference<InsertionHandler> reference,
                                    InsertionHandler service) {}
						});
	        
		    engineServiceTracker.open();
	    }
        catch (Exception e) {
	        e.printStackTrace();
        }
	    
    }

	@Override
	public void stop(BundleContext context) throws Exception {
		// The registered auxiliary services are removed automatically by the OSGi platform
	}
	
}
