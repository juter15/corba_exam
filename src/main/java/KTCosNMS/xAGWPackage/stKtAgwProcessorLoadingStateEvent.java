package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/stKtAgwProcessorLoadingStateEvent.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public final class stKtAgwProcessorLoadingStateEvent implements org.omg.CORBA.portable.IDLEntity
{
  public short agwType = (short)0;

  // Access Gateway Type
  public String agwId = null;

  // Access Gateway Id
  public short tid = (short)0;

  // Target System Id
  public short ssid = (short)0;

  // SubSystem Id
  public short oid = (short)0;

  // SubSystem Object Id
  public short rid = (short)0;

  // System Rack Id
  public short sid = (short)0;

  // System Shelf Id
  public short cid = (short)0;

  // System Circuit Id
  public short lid = (short)0;

  // Line or Port Id
  public String procName = null;

  // Processor Name
  public short loadingState = (short)0;

  // Loading State ( Start / End / Fail )
  public String date = null;

  public stKtAgwProcessorLoadingStateEvent ()
  {
  } // ctor

  public stKtAgwProcessorLoadingStateEvent (short _agwType, String _agwId, short _tid, short _ssid, short _oid, short _rid, short _sid, short _cid, short _lid, String _procName, short _loadingState, String _date)
  {
    agwType = _agwType;
    agwId = _agwId;
    tid = _tid;
    ssid = _ssid;
    oid = _oid;
    rid = _rid;
    sid = _sid;
    cid = _cid;
    lid = _lid;
    procName = _procName;
    loadingState = _loadingState;
    date = _date;
  } // ctor

} // class stKtAgwProcessorLoadingStateEvent
