package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/AgwInfoSt.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
*/

public final class AgwInfoSt implements org.omg.CORBA.portable.IDLEntity
{
  public String agwId = null;
  public String agwName = null;
  public String equipmentId = null;
  public String emsId = null;
  public String managementIpAddress = null;
  public String swVersion = null;
  public String hwVersion = null;
  public String swUpdate = null;
  public String hwUpdate = null;
  public KTCosNMS.xAGWPackage.UsageStateEnum usageState = null;
  public KTCosNMS.xAGWPackage.CommonOptSt varCommonOptSt = null;

  public AgwInfoSt ()
  {
  } // ctor

  public AgwInfoSt (String _agwId, String _agwName, String _equipmentId, String _emsId, String _managementIpAddress, String _swVersion, String _hwVersion, String _swUpdate, String _hwUpdate, KTCosNMS.xAGWPackage.UsageStateEnum _usageState, KTCosNMS.xAGWPackage.CommonOptSt _varCommonOptSt)
  {
    agwId = _agwId;
    agwName = _agwName;
    equipmentId = _equipmentId;
    emsId = _emsId;
    managementIpAddress = _managementIpAddress;
    swVersion = _swVersion;
    hwVersion = _hwVersion;
    swUpdate = _swUpdate;
    hwUpdate = _hwUpdate;
    usageState = _usageState;
    varCommonOptSt = _varCommonOptSt;
  } // ctor

} // class AgwInfoSt