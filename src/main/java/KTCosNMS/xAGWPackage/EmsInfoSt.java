package KTCosNMS.xAGWPackage;


import lombok.ToString;

/**
* KTCosNMS/xAGWPackage/EmsInfoSt.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
*/
@ToString
public final class EmsInfoSt implements org.omg.CORBA.portable.IDLEntity
{
  public String emsId = null;
  public String emsName = null;
  public String managementIpAddress = null;
  public String opTime = null;
  public String swVersion = null;
  public String update = null;
  public KTCosNMS.xAGWPackage.UsageStateEnum usageState = null;
  public KTCosNMS.xAGWPackage.CommonOptSt varCommonOptSt = null;

  public EmsInfoSt ()
  {
  } // ctor

  public EmsInfoSt (String _emsId, String _emsName, String _managementIpAddress, String _opTime, String _swVersion, String _update, KTCosNMS.xAGWPackage.UsageStateEnum _usageState, KTCosNMS.xAGWPackage.CommonOptSt _varCommonOptSt)
  {
    emsId = _emsId;
    emsName = _emsName;
    managementIpAddress = _managementIpAddress;
    opTime = _opTime;
    swVersion = _swVersion;
    update = _update;
    usageState = _usageState;
    varCommonOptSt = _varCommonOptSt;
  } // ctor

} // class EmsInfoSt
