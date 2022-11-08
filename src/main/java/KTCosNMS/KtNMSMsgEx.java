package KTCosNMS;


/**
* KTCosNMS/KtNMSMsgEx.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/


//------------------------------------------------------------------------------------------------------
public final class KtNMSMsgEx extends org.omg.CORBA.UserException
{
  public short neType = (short)0;
  public short msgType = (short)0;
  public int opCode = (int)0;
  public int seqNo = (int)0;
  public String reason = null;
  public String location = null;

  public KtNMSMsgEx ()
  {
    super(KtNMSMsgExHelper.id());
  } // ctor

  public KtNMSMsgEx (short _neType, short _msgType, int _opCode, int _seqNo, String _reason, String _location)
  {
    super(KtNMSMsgExHelper.id());
    neType = _neType;
    msgType = _msgType;
    opCode = _opCode;
    seqNo = _seqNo;
    reason = _reason;
    location = _location;
  } // ctor


  public KtNMSMsgEx (String $reason, short _neType, short _msgType, int _opCode, int _seqNo, String _reason, String _location)
  {
    super(KtNMSMsgExHelper.id() + "  " + $reason);
    neType = _neType;
    msgType = _msgType;
    opCode = _opCode;
    seqNo = _seqNo;
    reason = _reason;
    location = _location;
  } // ctor

} // class KtNMSMsgEx
