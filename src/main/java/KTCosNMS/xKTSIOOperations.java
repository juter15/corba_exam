package KTCosNMS;


/**
* KTCosNMS/xKTSIOOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/


//--------------------------------------------------------------------------------------
public interface xKTSIOOperations 
{

  //---------------------------------------------------------------------------------------
  void recvIt (KTCosNMS.KTSIOMsg in_KtSioMsg, KTCosNMS.KTSIOMsgHolder out_KtSioMsg);
  void recvAsyncIt (KTCosNMS.KTSIOMsg in_KtSioMsg, KTCosNMS.xKTSIO in_replyKTSIO);
  void recvBulkIt (KTCosNMS.KTSIOMsg[] in_KtSioMsgSeq, KTCosNMS.KTSIOMsgSeqHolder out_KtSioMsgSeq);
  void recvAsyncBulkIt (KTCosNMS.KTSIOMsg[] in_KtSioMsgSeq, KTCosNMS.xKTSIO in_replyKTSIO);
  String echoString (String message);
} // interface xKTSIOOperations
