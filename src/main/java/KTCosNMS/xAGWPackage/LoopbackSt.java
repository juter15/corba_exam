package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/LoopbackSt.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class LoopbackSt implements org.omg.CORBA.portable.IDLEntity
{
  public String emsId = null;
  public String agwId = null;
  public String rackId = null;
  public String shelfId = null;
  public String slotId = null;
  public String portId = null;
  public KTCosNMS.xAGWPackage.LoopBackStatusEnum loopbackStatus = null;

  public LoopbackSt ()
  {
  } // ctor

  public LoopbackSt (String _emsId, String _agwId, String _rackId, String _shelfId, String _slotId, String _portId, KTCosNMS.xAGWPackage.LoopBackStatusEnum _loopbackStatus)
  {
    emsId = _emsId;
    agwId = _agwId;
    rackId = _rackId;
    shelfId = _shelfId;
    slotId = _slotId;
    portId = _portId;
    loopbackStatus = _loopbackStatus;
  } // ctor

} // class LoopbackSt
