package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/stKtAgwGetEventFilterReq.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public final class stKtAgwGetEventFilterReq implements org.omg.CORBA.portable.IDLEntity
{
  public short agwType = (short)0;

  // Access Gateway Type
  public String agwId = null;

  public stKtAgwGetEventFilterReq ()
  {
  } // ctor

  public stKtAgwGetEventFilterReq (short _agwType, String _agwId)
  {
    agwType = _agwType;
    agwId = _agwId;
  } // ctor

} // class stKtAgwGetEventFilterReq