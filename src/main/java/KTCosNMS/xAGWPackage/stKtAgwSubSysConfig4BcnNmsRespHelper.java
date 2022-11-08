package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/stKtAgwSubSysConfig4BcnNmsRespHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

abstract public class stKtAgwSubSysConfig4BcnNmsRespHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/stKtAgwSubSysConfig4BcnNmsResp:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.stKtAgwSubSysConfig4BcnNmsResp that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.stKtAgwSubSysConfig4BcnNmsResp extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [13];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "sysId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "sysName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "subSysId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "equipmentId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "emsId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "officeId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "headquarterId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[7] = new org.omg.CORBA.StructMember (
            "vendorName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[8] = new org.omg.CORBA.StructMember (
            "managementIpAddress",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[9] = new org.omg.CORBA.StructMember (
            "manufactureDate",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[10] = new org.omg.CORBA.StructMember (
            "serialNumber",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[11] = new org.omg.CORBA.StructMember (
            "description",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[12] = new org.omg.CORBA.StructMember (
            "usageState",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (KTCosNMS.xAGWPackage.stKtAgwSubSysConfig4BcnNmsRespHelper.id (), "stKtAgwSubSysConfig4BcnNmsResp", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static KTCosNMS.xAGWPackage.stKtAgwSubSysConfig4BcnNmsResp read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.stKtAgwSubSysConfig4BcnNmsResp value = new KTCosNMS.xAGWPackage.stKtAgwSubSysConfig4BcnNmsResp ();
    value.sysId = istream.read_string ();
    value.sysName = istream.read_string ();
    value.subSysId = istream.read_string ();
    value.equipmentId = istream.read_string ();
    value.emsId = istream.read_string ();
    value.officeId = istream.read_string ();
    value.headquarterId = istream.read_string ();
    value.vendorName = istream.read_string ();
    value.managementIpAddress = istream.read_string ();
    value.manufactureDate = istream.read_string ();
    value.serialNumber = istream.read_string ();
    value.description = istream.read_string ();
    value.usageState = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.stKtAgwSubSysConfig4BcnNmsResp value)
  {
    ostream.write_string (value.sysId);
    ostream.write_string (value.sysName);
    ostream.write_string (value.subSysId);
    ostream.write_string (value.equipmentId);
    ostream.write_string (value.emsId);
    ostream.write_string (value.officeId);
    ostream.write_string (value.headquarterId);
    ostream.write_string (value.vendorName);
    ostream.write_string (value.managementIpAddress);
    ostream.write_string (value.manufactureDate);
    ostream.write_string (value.serialNumber);
    ostream.write_string (value.description);
    ostream.write_long (value.usageState);
  }

}
