package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/stKtAgwEmsConfig4BcnNmsResp.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class stKtAgwEmsConfig4BcnNmsResp implements org.omg.CORBA.portable.IDLEntity
{
  public String emsId = null;

  // EMS Id(M) : use KT's EMS Colcode
  public String emsName = null;

  // EMS Name(M): use EMS's hostname
  public String equipmentId = null;

  // Equipment Id(M) : use KT's EMS Colcode
  public String officeId = null;

  // KT's brance office name(O)
  public String headquarterId = null;

  // KT's headquarter name(O)
  public String vendorName = null;

  // EMS vendor's name(O) : LG , SAMSUNG, LUCENT ...
  public String managementIpAddress = null;

  // EMS's Ip address(M)
  public String manufactureDate = null;

  // EMS's installed date in KT official site(M), (YYYY-MM-DD hh:mm:ss)
  public String serialNumber = null;

  //  you can get following information -> SunOS linn 5.8 Generic_108528-14 sun4u
  public String description = null;

  // EMS's additional information(O)
  public int usageState = (int)0;

  public stKtAgwEmsConfig4BcnNmsResp ()
  {
  } // ctor

  public stKtAgwEmsConfig4BcnNmsResp (String _emsId, String _emsName, String _equipmentId, String _officeId, String _headquarterId, String _vendorName, String _managementIpAddress, String _manufactureDate, String _serialNumber, String _description, int _usageState)
  {
    emsId = _emsId;
    emsName = _emsName;
    equipmentId = _equipmentId;
    officeId = _officeId;
    headquarterId = _headquarterId;
    vendorName = _vendorName;
    managementIpAddress = _managementIpAddress;
    manufactureDate = _manufactureDate;
    serialNumber = _serialNumber;
    description = _description;
    usageState = _usageState;
  } // ctor

} // class stKtAgwEmsConfig4BcnNmsResp
