package KTCosNMS;


/**
* KTCosNMS/xKTSIOPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/


//--------------------------------------------------------------------------------------
public abstract class xKTSIOPOA extends org.omg.PortableServer.Servant
 implements KTCosNMS.xKTSIOOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("recvIt", new java.lang.Integer (0));
    _methods.put ("recvAsyncIt", new java.lang.Integer (1));
    _methods.put ("recvBulkIt", new java.lang.Integer (2));
    _methods.put ("recvAsyncBulkIt", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  //---------------------------------------------------------------------------------------
       case 0:  // KTCosNMS/xKTSIO/recvIt
       {
         KTCosNMS.KTSIOMsg in_KtSioMsg = KTCosNMS.KTSIOMsgHelper.read (in);
//         KTCosNMS.KTSIOMsgHolder out_KtSioMsg = new KTCosNMS.KTSIOMsgHolder ();
         KTCosNMS.KTSIOMsgHolder out_KtSioMsg = new KTCosNMS.KTSIOMsgHolder (in_KtSioMsg);
         this.recvIt (in_KtSioMsg, out_KtSioMsg);
         out = $rh.createReply();
         KTCosNMS.KTSIOMsgHelper.write (out, out_KtSioMsg.value);
         break;
       }

       case 1:  // KTCosNMS/xKTSIO/recvAsyncIt
       {
         KTCosNMS.KTSIOMsg in_KtSioMsg = KTCosNMS.KTSIOMsgHelper.read (in);
         KTCosNMS.xKTSIO in_replyKTSIO = KTCosNMS.xKTSIOHelper.read (in);
         this.recvAsyncIt (in_KtSioMsg, in_replyKTSIO);
         out = $rh.createReply();
         break;
       }

       case 2:  // KTCosNMS/xKTSIO/recvBulkIt
       {
         KTCosNMS.KTSIOMsg in_KtSioMsgSeq[] = KTCosNMS.KTSIOMsgSeqHelper.read (in);
         KTCosNMS.KTSIOMsgSeqHolder out_KtSioMsgSeq = new KTCosNMS.KTSIOMsgSeqHolder ();
         this.recvBulkIt (in_KtSioMsgSeq, out_KtSioMsgSeq);
         out = $rh.createReply();
         KTCosNMS.KTSIOMsgSeqHelper.write (out, out_KtSioMsgSeq.value);
         break;
       }

       case 3:  // KTCosNMS/xKTSIO/recvAsyncBulkIt
       {
         KTCosNMS.KTSIOMsg in_KtSioMsgSeq[] = KTCosNMS.KTSIOMsgSeqHelper.read (in);
         KTCosNMS.xKTSIO in_replyKTSIO = KTCosNMS.xKTSIOHelper.read (in);
         this.recvAsyncBulkIt (in_KtSioMsgSeq, in_replyKTSIO);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:KTCosNMS/xKTSIO:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public xKTSIO _this() 
  {
    return xKTSIOHelper.narrow(
    super._this_object());
  }

  public xKTSIO _this(org.omg.CORBA.ORB orb) 
  {
    return xKTSIOHelper.narrow(
    super._this_object(orb));
  }


} // class xKTSIOPOA
