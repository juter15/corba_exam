package KTCosNMS;


import lombok.extern.slf4j.Slf4j;

/**
* KTCosNMS/_xKTSIOStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/


//--------------------------------------------------------------------------------------
    @Slf4j
public class _xKTSIOStub extends org.omg.CORBA.portable.ObjectImpl implements KTCosNMS.xKTSIO
{


  //---------------------------------------------------------------------------------------
  public void recvIt (KTCosNMS.KTSIOMsg in_KtSioMsg, KTCosNMS.KTSIOMsgHolder out_KtSioMsg)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("recvIt", true);
                KTCosNMS.KTSIOMsgHelper.write ($out, in_KtSioMsg);
                $in = _invoke ($out);
                out_KtSioMsg.value = KTCosNMS.KTSIOMsgHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                recvIt (in_KtSioMsg, out_KtSioMsg        );
            } finally {
                _releaseReply ($in);
            }
  } // recvIt

  public void recvAsyncIt (KTCosNMS.KTSIOMsg in_KtSioMsg, KTCosNMS.xKTSIO in_replyKTSIO)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("recvAsyncIt", false);
                KTCosNMS.KTSIOMsgHelper.write ($out, in_KtSioMsg);
                KTCosNMS.xKTSIOHelper.write ($out, in_replyKTSIO);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                recvAsyncIt (in_KtSioMsg, in_replyKTSIO        );
            } finally {
                _releaseReply ($in);
            }
  } // recvAsyncIt

  public void recvBulkIt (KTCosNMS.KTSIOMsg[] in_KtSioMsgSeq, KTCosNMS.KTSIOMsgSeqHolder out_KtSioMsgSeq)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("recvBulkIt", true);
                KTCosNMS.KTSIOMsgSeqHelper.write ($out, in_KtSioMsgSeq);
                $in = _invoke ($out);
                out_KtSioMsgSeq.value = KTCosNMS.KTSIOMsgSeqHelper.read ($in);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                recvBulkIt (in_KtSioMsgSeq, out_KtSioMsgSeq        );
            } finally {
                _releaseReply ($in);
            }
  } // recvBulkIt

  public void recvAsyncBulkIt (KTCosNMS.KTSIOMsg[] in_KtSioMsgSeq, KTCosNMS.xKTSIO in_replyKTSIO)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("recvAsyncBulkIt", false);
                KTCosNMS.KTSIOMsgSeqHelper.write ($out, in_KtSioMsgSeq);

                KTCosNMS.xKTSIOHelper.write ($out, in_replyKTSIO);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                recvAsyncBulkIt (in_KtSioMsgSeq, in_replyKTSIO        );
            } finally {
                _releaseReply ($in);
            }
  } // recvAsyncBulkIt

  public String echoString (String message)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("echoString", true);
                $out.write_string (message);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return echoString (message        );
            } finally {
                _releaseReply ($in);
            }
  } // echoString

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:KTCosNMS/xKTSIO:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _xKTSIOStub