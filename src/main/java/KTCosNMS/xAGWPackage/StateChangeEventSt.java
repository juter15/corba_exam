package KTCosNMS.xAGWPackage;


import lombok.ToString;

/**
* KTCosNMS/xAGWPackage/StateChangeEventSt.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/
@ToString
public final class StateChangeEventSt implements org.omg.CORBA.portable.IDLEntity
{
  public String emsId = null;
  public String agwId = null;
  public String status = null;
  public String location = null;
  public String probableCause = null;
  public String addMessage = null;
  public String eventTime = null;

  public StateChangeEventSt ()
  {
  } // ctor

  public StateChangeEventSt (String _emsId, String _agwId, String _status, String _location, String _probableCause, String _addMessage, String _eventTime)
  {
    emsId = _emsId;
    agwId = _agwId;
    status = _status;
    location = _location;
    probableCause = _probableCause;
    addMessage = _addMessage;
    eventTime = _eventTime;
  } // ctor

} // class StateChangeEventSt
