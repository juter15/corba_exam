package KTCosNMS;


/**
* KTCosNMS/xEXCHPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/


//--------------------------------------------------------------------------------------
public abstract class xEXCHPOA extends org.omg.PortableServer.Servant
 implements KTCosNMS.xEXCHOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:KTCosNMS/xEXCH:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public xEXCH _this() 
  {
    return xEXCHHelper.narrow(
    super._this_object());
  }

  public xEXCH _this(org.omg.CORBA.ORB orb) 
  {
    return xEXCHHelper.narrow(
    super._this_object(orb));
  }


} // class xEXCHPOA
