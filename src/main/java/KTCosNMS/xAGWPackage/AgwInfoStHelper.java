package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/AgwInfoStHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
*/

abstract public class AgwInfoStHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/AgwInfoSt:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.AgwInfoSt that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.AgwInfoSt extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [11];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "agwId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "agwName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "equipmentId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "emsId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "managementIpAddress",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "swVersion",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "hwVersion",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[7] = new org.omg.CORBA.StructMember (
            "swUpdate",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[8] = new org.omg.CORBA.StructMember (
            "hwUpdate",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.UsageStateEnumHelper.type ();
          _members0[9] = new org.omg.CORBA.StructMember (
            "usageState",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.CommonOptStHelper.type ();
          _members0[10] = new org.omg.CORBA.StructMember (
            "varCommonOptSt",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (KTCosNMS.xAGWPackage.AgwInfoStHelper.id (), "AgwInfoSt", _members0);
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

  public static KTCosNMS.xAGWPackage.AgwInfoSt read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.AgwInfoSt value = new KTCosNMS.xAGWPackage.AgwInfoSt ();
    value.agwId = istream.read_string ();
    value.agwName = istream.read_string ();
    value.equipmentId = istream.read_string ();
    value.emsId = istream.read_string ();
    value.managementIpAddress = istream.read_string ();
    value.swVersion = istream.read_string ();
    value.hwVersion = istream.read_string ();
    value.swUpdate = istream.read_string ();
    value.hwUpdate = istream.read_string ();
    value.usageState = KTCosNMS.xAGWPackage.UsageStateEnumHelper.read (istream);
    value.varCommonOptSt = KTCosNMS.xAGWPackage.CommonOptStHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.AgwInfoSt value)
  {
    ostream.write_string (value.agwId);
    ostream.write_string (value.agwName);
    ostream.write_string (value.equipmentId);
    ostream.write_string (value.emsId);
    ostream.write_string (value.managementIpAddress);
    ostream.write_string (value.swVersion);
    ostream.write_string (value.hwVersion);
    ostream.write_string (value.swUpdate);
    ostream.write_string (value.hwUpdate);
    KTCosNMS.xAGWPackage.UsageStateEnumHelper.write (ostream, value.usageState);
    KTCosNMS.xAGWPackage.CommonOptStHelper.write (ostream, value.varCommonOptSt);
  }

}
