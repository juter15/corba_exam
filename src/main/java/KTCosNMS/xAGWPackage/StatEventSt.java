package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/StatEventSt.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class StatEventSt implements org.omg.CORBA.portable.IDLEntity
{
  public String emsId = null;
  public String agwId = null;
  public String userId = null;
  public String password = null;
  public String fileLocation = null;
  public String fileSize = null;
  public String eventTime = null;

  public StatEventSt ()
  {
  } // ctor

  public StatEventSt (String _emsId, String _agwId, String _userId, String _password, String _fileLocation, String _fileSize, String _eventTime)
  {
    emsId = _emsId;
    agwId = _agwId;
    userId = _userId;
    password = _password;
    fileLocation = _fileLocation;
    fileSize = _fileSize;
    eventTime = _eventTime;
  } // ctor

} // class StatEventSt
