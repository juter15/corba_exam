package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/stKtAgwAlarmHistoryResp.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class stKtAgwAlarmHistoryResp implements org.omg.CORBA.portable.IDLEntity
{
  public short agwType = (short)0;

  // Access Gateway Type
  public String agwId = null;

  // Access Gateway Id
  public int alarmId = (int)0;

  // Alarm Id ( Alarm OpCode )
  public short severity = (short)0;

  // Alarm Severity
  public short correlationFlag = (short)0;

  // Alarm Correlation Flag
  public String connectedEx = null;

  // Connected Exchange Truman Code
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
  public short recovery = (short)0;

  // Alarm Recovery or Occurrence. Flag
  public String occurrenceDate = null;

  // Alarm Occurrence. Date (YYYY-MM-DD hh:mm:ss)
  public String recoveryDate = null;

  public stKtAgwAlarmHistoryResp ()
  {
  } // ctor

  public stKtAgwAlarmHistoryResp (short _agwType, String _agwId, int _alarmId, short _severity, short _correlationFlag, String _connectedEx, short _tid, short _ssid, short _oid, short _rid, short _sid, short _cid, short _lid, short _recovery, String _occurrenceDate, String _recoveryDate)
  {
    agwType = _agwType;
    agwId = _agwId;
    alarmId = _alarmId;
    severity = _severity;
    correlationFlag = _correlationFlag;
    connectedEx = _connectedEx;
    tid = _tid;
    ssid = _ssid;
    oid = _oid;
    rid = _rid;
    sid = _sid;
    cid = _cid;
    lid = _lid;
    recovery = _recovery;
    occurrenceDate = _occurrenceDate;
    recoveryDate = _recoveryDate;
  } // ctor

} // class stKtAgwAlarmHistoryResp
