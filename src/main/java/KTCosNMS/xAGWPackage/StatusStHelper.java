package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/StatusStHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

abstract public class StatusStHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/StatusSt:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.StatusSt that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.StatusSt extract (org.omg.CORBA.Any a)
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
          _tcOf_members0 = KTCosNMS.xAGWPackage.UsageStateEnumHelper.type ();
          _members0[0] = new org.omg.CORBA.StructMember (
            "usageStatus",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.OperStatusEnumHelper.type ();
          _members0[1] = new org.omg.CORBA.StructMember (
            "operStatus",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.EquipStatusEnumHelper.type ();
          _members0[2] = new org.omg.CORBA.StructMember (
            "equipStatus",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.AdminStatusEnumHelper.type ();
          _members0[3] = new org.omg.CORBA.StructMember (
            "adminStatus",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "alarmStatus",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.LoopBackStatusEnumHelper.type ();
          _members0[5] = new org.omg.CORBA.StructMember (
            "loopBackStatus",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.ModeStatusEnumHelper.type ();
          _members0[6] = new org.omg.CORBA.StructMember (
            "protectionStatus",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[7] = new org.omg.CORBA.StructMember (
            "swVersion",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[8] = new org.omg.CORBA.StructMember (
            "hwVersion",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[9] = new org.omg.CORBA.StructMember (
            "fwVersion",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[10] = new org.omg.CORBA.StructMember (
            "failReason",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (KTCosNMS.xAGWPackage.StatusStHelper.id (), "StatusSt", _members0);
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

  public static KTCosNMS.xAGWPackage.StatusSt read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.StatusSt value = new KTCosNMS.xAGWPackage.StatusSt ();
    value.usageStatus = KTCosNMS.xAGWPackage.UsageStateEnumHelper.read (istream);
    value.operStatus = KTCosNMS.xAGWPackage.OperStatusEnumHelper.read (istream);
    value.equipStatus = KTCosNMS.xAGWPackage.EquipStatusEnumHelper.read (istream);
    value.adminStatus = KTCosNMS.xAGWPackage.AdminStatusEnumHelper.read (istream);
    value.alarmStatus = istream.read_string ();
    value.loopBackStatus = KTCosNMS.xAGWPackage.LoopBackStatusEnumHelper.read (istream);
    value.protectionStatus = KTCosNMS.xAGWPackage.ModeStatusEnumHelper.read (istream);
    value.swVersion = istream.read_string ();
    value.hwVersion = istream.read_string ();
    value.fwVersion = istream.read_string ();
    value.failReason = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.StatusSt value)
  {
    KTCosNMS.xAGWPackage.UsageStateEnumHelper.write (ostream, value.usageStatus);
    KTCosNMS.xAGWPackage.OperStatusEnumHelper.write (ostream, value.operStatus);
    KTCosNMS.xAGWPackage.EquipStatusEnumHelper.write (ostream, value.equipStatus);
    KTCosNMS.xAGWPackage.AdminStatusEnumHelper.write (ostream, value.adminStatus);
    ostream.write_string (value.alarmStatus);
    KTCosNMS.xAGWPackage.LoopBackStatusEnumHelper.write (ostream, value.loopBackStatus);
    KTCosNMS.xAGWPackage.ModeStatusEnumHelper.write (ostream, value.protectionStatus);
    ostream.write_string (value.swVersion);
    ostream.write_string (value.hwVersion);
    ostream.write_string (value.fwVersion);
    ostream.write_string (value.failReason);
  }

}
