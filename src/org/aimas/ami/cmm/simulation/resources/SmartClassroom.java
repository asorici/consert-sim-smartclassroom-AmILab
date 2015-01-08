package org.aimas.ami.cmm.simulation.resources;

import org.aimas.ami.contextrep.vocabulary.ConsertCore;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public class SmartClassroom {
	/** <p>The RDF model that holds the vocabulary terms</p> */
    private static Model m_model = ModelFactory.createDefaultModel();
    
    public final static String BASE_URI = "http://pervasive.semanticweb.org/ont/2014/07/smartclassroom/core";
	public final static String NS = BASE_URI + "#";
	
	public final static String BOOTSTRAP_BASE = "http://pervasive.semanticweb.org/ont/2014/07/smartclassroom/bootstrap";
	public final static String BOOTSTRAP_NS = BOOTSTRAP_BASE + "#";
	
	public static final String SOUPA_TIME_BASE = "http://pervasive.semanticweb.org/ont/2004/06/time";
	public static final String SOUPA_TIME_NS = SOUPA_TIME_BASE + "#";
	
	public static final String SOUPA_SPACE_BASE = "http://pervasive.semanticweb.org/ont/2004/06/space";
	public static final String SOUPA_SPACE_NS = SOUPA_SPACE_BASE + "#";
	
	public static final String SOUPA_DEVICE_BASE = "http://pervasive.semanticweb.org/ont/2004/06/device";
	public static final String SOUPA_DEVICE_NS = SOUPA_DEVICE_BASE + "#";
	
	public static final String SOUPA_PERSON_BASE = "http://pervasive.semanticweb.org/ont/2004/06/person";
	public static final String SOUPA_PERSON_NS = SOUPA_PERSON_BASE + "#";
	
	
	
	/** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
	
    // Vocabulary classes
    /////////////////////
    public final static Resource SchoolBuilding = m_model.createResource( NS + "SchoolBuilding" );
    public final static Resource Room = m_model.createResource( NS + "Room" );
    public final static Resource MultiFunctionalRoom = m_model.createResource( NS + "MultiFunctionalRoom" );
    public final static Resource RoomSection = m_model.createResource( NS + "RoomSection" );
    public final static Resource TimedActivity = m_model.createResource( NS + "TimedActivity" );
    public final static Resource AdHocDiscussion = m_model.createResource( NS + "AdHocDiscussion" );
    public final static Resource TeachingActivity = m_model.createResource( NS + "TeachingActivity" );
    
    public final static Resource SkeletonPosition = m_model.createResource( NS + "SkeletonPosition" );
    public final static Resource KinectSkeleton = m_model.createResource( NS + "KinectSkeleton" );
    
    public final static Resource Smartphone = m_model.createResource( NS + "Smartphone" );
    public final static Resource LuminositySensor = m_model.createResource( NS + "LuminositySensor" );
    public final static Resource Microphone = m_model.createResource( NS + "Microphone" );
    public final static Resource PresenceSensor = m_model.createResource( NS + "PresenceSensor" );
    public final static Resource TemperatureSensor = m_model.createResource( NS + "TemperatureSensor" );
    public final static Resource KinectCamera = m_model.createResource( NS + "KinectCamera" );
    
    public final static Resource HostsTimedActivity = m_model.createResource( NS + "HostsTimedActivity" );
    public final static Resource HostsAdHocDiscussion = m_model.createResource( NS + "HostsAdHocDiscussion" );
    public final static Resource HostsTeachingClass = m_model.createResource( NS + "HostsTeachingClass" );
    public final static Resource sensesSkeletonInPosition = m_model.createResource( NS + "sensesSkeletonInPosition" );
    
    public final static Resource Person = m_model.createResource( SOUPA_PERSON_NS + "Person" );
    public final static Resource InstantThing = m_model.createResource( SOUPA_TIME_NS + "InstantThing" );
    
    // Vocabulary properties
 	////////////////////////
 	public final static Property hasCameraRole = m_model.createProperty( NS + "hasCameraRole" );
 	public final static Property hasSkeletonRole = m_model.createProperty( NS + "hasSkeletonRole" );
 	public final static Property hasSkelPositionRole = m_model.createProperty( NS + "hasSkelPositionRole" );
 	
 	public final static Property hasDerivedLocation = m_model.createProperty( SOUPA_DEVICE_NS + "hasDerivedLocation" );
 	public final static Property hasProfiledLocation = m_model.createProperty( SOUPA_DEVICE_NS + "hasProfiledLocation" );
 	public final static Property bluetoothMAC = m_model.createProperty( SOUPA_DEVICE_NS + "bluetoothMAC" );
 	public final static Property hasUser = m_model.createProperty( SOUPA_DEVICE_NS + "hasUser" );
 	
 	public final static Property locatedIn = m_model.createProperty( SOUPA_PERSON_NS + "locatedIn" );
 	public final static Property engagedIn = m_model.createProperty( NS + "engagedIn" );
 	public final static Property takesPlaceIn = m_model.createProperty( NS + "takesPlaceIn" );
 	
 	public final static Property sensesBluetoothAddress = m_model.createProperty( NS + "sensesBluetoothAddress" );
 	public final static Property sensesLuminosity = m_model.createProperty( NS + "sensesLuminosity" );
 	public final static Property sensesTemperature = m_model.createProperty( NS + "sensesTemperature" );
 	public final static Property hasNoiseLevel = m_model.createProperty( NS + "hasNoiseLevel" );
 	
 	public final static Property from = m_model.createProperty( SOUPA_TIME_NS + "from" );
 	public final static Property to = m_model.createProperty( SOUPA_TIME_NS + "to" );
 	public final static Property at = m_model.createProperty( SOUPA_TIME_NS + "at" );
 	
 	public final static Property spatiallySubsumedBy = m_model.createProperty( SOUPA_SPACE_NS + "spatiallySubsumedBy" );
 	
 	
 	// Vocabulary Individuals
 	/////////////////////////
 	public final static Resource EF210 = m_model.createResource( BOOTSTRAP_NS + "EF210", MultiFunctionalRoom);
 	
 	public final static Resource EF210_PresenterArea = m_model.createResource( BOOTSTRAP_NS + "EF210_PresenterArea", RoomSection);
 	public final static Resource EF210_Section1_Left = m_model.createResource( BOOTSTRAP_NS + "EF210_Section1_Left", RoomSection);
 	public final static Resource EF210_Section1_Right = m_model.createResource( BOOTSTRAP_NS + "EF210_Section1_Right", RoomSection);
 	public final static Resource EF210_Section2_Left = m_model.createResource( BOOTSTRAP_NS + "EF210_Section2_Left", RoomSection);
 	public final static Resource EF210_Section2_Right = m_model.createResource( BOOTSTRAP_NS + "EF210_Section2_Right", RoomSection);
 	public final static Resource EF210_Section3_Left = m_model.createResource( BOOTSTRAP_NS + "EF210_Section3_Left", RoomSection);
 	public final static Resource EF210_Section3_Right = m_model.createResource( BOOTSTRAP_NS + "EF210_Section3_Right", RoomSection);
 	
 	public final static Resource Kinect_EF210_PresenterArea = m_model.createResource( BOOTSTRAP_NS + "Kinect_EF210_PresenterArea", KinectCamera);
 	public final static Resource Kinect_EF210_Section1_Left = m_model.createResource( BOOTSTRAP_NS + "Kinect_EF210_Section1_Left", KinectCamera);
 	public final static Resource Kinect_EF210_Section1_Right = m_model.createResource( BOOTSTRAP_NS + "Kinect_EF210_Section1_Right", KinectCamera);
 	public final static Resource Kinect_EF210_Section2_Left = m_model.createResource( BOOTSTRAP_NS + "Kinect_EF210_Section2_Left", KinectCamera);
 	public final static Resource Kinect_EF210_Section2_Right = m_model.createResource( BOOTSTRAP_NS + "Kinect_EF210_Section2_Right", KinectCamera);
 	public final static Resource Kinect_EF210_Section3_Left = m_model.createResource( BOOTSTRAP_NS + "Kinect_EF210_Section3_Left", KinectCamera);
 	public final static Resource Kinect_EF210_Section3_Right = m_model.createResource( BOOTSTRAP_NS + "Kinect_EF210_Section3_Right", KinectCamera);
 	
 	public final static Resource Lum_EF210_PresenterArea = m_model.createResource( BOOTSTRAP_NS + "Lum_EF210_PresenterArea", LuminositySensor);
 	public final static Resource Lum_EF210_Section1_Right = m_model.createResource( BOOTSTRAP_NS + "Lum_EF210_Section1_Right", LuminositySensor);
 	public final static Resource Lum_EF210_Section2_Right = m_model.createResource( BOOTSTRAP_NS + "Lum_EF210_Section2_Right", LuminositySensor);
 	public final static Resource Lum_EF210_Section3_Right = m_model.createResource( BOOTSTRAP_NS + "Lum_EF210_Section3_Right", LuminositySensor);
 	
 	public final static Resource Temp_EF210_Section1_Left = m_model.createResource( BOOTSTRAP_NS + "Temp_EF210_Section1_Left", TemperatureSensor);
 	public final static Resource Temp_EF210_Section1_Right = m_model.createResource( BOOTSTRAP_NS + "Temp_EF210_Section1_Right", TemperatureSensor);
 	public final static Resource Temp_EF210_Section3_Left = m_model.createResource( BOOTSTRAP_NS + "Temp_EF210_Section3_Left", TemperatureSensor);
 	public final static Resource Temp_EF210_Section3_Right = m_model.createResource( BOOTSTRAP_NS + "Temp_EF210_Section3_Right", TemperatureSensor);
 	
 	public final static Resource Mic_EF210_PresenterArea = m_model.createResource( BOOTSTRAP_NS + "Mic_EF210_PresenterArea", Microphone);
 	public final static Resource Mic_EF210_Section1_Left = m_model.createResource( BOOTSTRAP_NS + "Mic_EF210_Section1_Left", Microphone);
 	public final static Resource Mic_EF210_Section1_Right = m_model.createResource( BOOTSTRAP_NS + "Mic_EF210_Section1_Right", Microphone);
 	public final static Resource Mic_EF210_Section2_Left = m_model.createResource( BOOTSTRAP_NS + "Mic_EF210_Section2_Left", Microphone);
 	public final static Resource Mic_EF210_Section2_Right = m_model.createResource( BOOTSTRAP_NS + "Mic_EF210_Section2_Right", Microphone);
 	public final static Resource Mic_EF210_Section3_Left = m_model.createResource( BOOTSTRAP_NS + "Mic_EF210_Section3_Left", Microphone);
 	public final static Resource Mic_EF210_Section3_Right = m_model.createResource( BOOTSTRAP_NS + "Mic_EF210_Section3_Right", Microphone);
 	
 	public final static Resource TeachingActivitySensor = m_model.createResource( BOOTSTRAP_NS + "TeachingActivitySensor", ConsertCore.CONTEXT_AGENT);
 	
 	public final static Resource PresenceSensor_EF210_PresenterArea = m_model.createResource( BOOTSTRAP_NS + "PresenceSensor_EF210_PresenterArea", PresenceSensor);
 	public final static Resource PresenceSensor_EF210_Section1_Left = m_model.createResource( BOOTSTRAP_NS + "PresenceSensor_EF210_Section1_Left", PresenceSensor);
 	public final static Resource PresenceSensor_EF210_Section1_Right = m_model.createResource( BOOTSTRAP_NS + "PresenceSensor_EF210_Section1_Right", PresenceSensor);
 	public final static Resource PresenceSensor_EF210_Section2_Left = m_model.createResource( BOOTSTRAP_NS + "PresenceSensor_EF210_Section2_Left", PresenceSensor);
 	public final static Resource PresenceSensor_EF210_Section2_Right = m_model.createResource( BOOTSTRAP_NS + "PresenceSensor_EF210_Section2_Right", PresenceSensor);
 	public final static Resource PresenceSensor_EF210_Section3_Left = m_model.createResource( BOOTSTRAP_NS + "PresenceSensor_EF210_Section3_Left", PresenceSensor);
 	public final static Resource PresenceSensor_EF210_Section3_Right = m_model.createResource( BOOTSTRAP_NS + "PresenceSensor_EF210_Section3_Right", PresenceSensor);
 	
 	
 	public final static Resource SkeletonSitting = m_model.createResource( NS + "SkeletonSitting", SkeletonPosition);
 	public final static Resource SkeletonStanding = m_model.createResource( NS + "SkeletonStanding", SkeletonPosition);
 	
}
