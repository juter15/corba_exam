package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/stKtAgwEocmsManagedAgwInfo.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public final class stKtAgwEocmsManagedAgwInfo implements org.omg.CORBA.portable.IDLEntity
{
  public String eocmsId = null;

  // EOCMS Id
  public String agwIdSeq[] = null;

  public stKtAgwEocmsManagedAgwInfo ()
  {
  } // ctor

  public stKtAgwEocmsManagedAgwInfo (String _eocmsId, String[] _agwIdSeq)
  {
    eocmsId = _eocmsId;
    agwIdSeq = _agwIdSeq;
  } // ctor

} // class stKtAgwEocmsManagedAgwInfo
