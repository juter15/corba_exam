package KTCosNMS.xAGWPackage;


import lombok.ToString;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* KTCosNMS/xAGWPackage/StateChangeEventSt.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
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


  public StateChangeEventSt setStateChangeEventSt() {
    StateChangeEventSt stateChangeEventSt = new StateChangeEventSt();
    stateChangeEventSt.emsId = "SLGA12132";
    stateChangeEventSt.agwId = "SLGS13241";

    stateChangeEventSt.status = "NMS0000";
    stateChangeEventSt.location = "";
    stateChangeEventSt.probableCause = "S";

    stateChangeEventSt.addMessage = "";
    stateChangeEventSt.eventTime = "20221104 00:00:00";

    return stateChangeEventSt;
  }

} // class StateChangeEventSt
