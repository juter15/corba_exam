package KTCosNMS.xAGWPackage;


import lombok.ToString;

/**
* KTCosNMS/xAGWPackage/stKtAgwSessionInfo.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/
@ToString
public final class stKtAgwSessionInfo implements org.omg.CORBA.portable.IDLEntity
{
  public String eocmsId = null;

  // EOCMS Id
  public String eocmsMdIOR = null;

  public stKtAgwSessionInfo ()
  {
  } // ctor

  public stKtAgwSessionInfo (String _eocmsId, String _eocmsMdIOR)
  {
    eocmsId = _eocmsId;
    eocmsMdIOR = _eocmsMdIOR;
  } // ctor

} // class stKtAgwSessionInfo
