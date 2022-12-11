package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/InterfaceInfoStHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

abstract public class InterfaceInfoStHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/InterfaceInfoSt:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.InterfaceInfoSt that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.InterfaceInfoSt extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [14];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "agwId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "Ifid",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.IfTypeEnumHelper.type ();
          _members0[2] = new org.omg.CORBA.StructMember (
            "ifType",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.IfSpeedEnumHelper.type ();
          _members0[3] = new org.omg.CORBA.StructMember (
            "ifSpeed",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.OperStatusEnumHelper.type ();
          _members0[4] = new org.omg.CORBA.StructMember (
            "ifOperStatus",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.AdminStatusEnumHelper.type ();
          _members0[5] = new org.omg.CORBA.StructMember (
            "ifAdminStatus",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "ipAddress",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[7] = new org.omg.CORBA.StructMember (
            "netMask",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[8] = new org.omg.CORBA.StructMember (
            "physicalAddress",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[9] = new org.omg.CORBA.StructMember (
            "aisStatus",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[10] = new org.omg.CORBA.StructMember (
            "dscpValue",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.LoopBackStatusEnumHelper.type ();
          _members0[11] = new org.omg.CORBA.StructMember (
            "loopBackStatus",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[12] = new org.omg.CORBA.StructMember (
            "failReason",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[13] = new org.omg.CORBA.StructMember (
            "alarmStatus",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (KTCosNMS.xAGWPackage.InterfaceInfoStHelper.id (), "InterfaceInfoSt", _members0);
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

  public static KTCosNMS.xAGWPackage.InterfaceInfoSt read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.InterfaceInfoSt value = new KTCosNMS.xAGWPackage.InterfaceInfoSt ();
    value.agwId = istream.read_string ();
    value.Ifid = istream.read_string ();
    value.ifType = KTCosNMS.xAGWPackage.IfTypeEnumHelper.read (istream);
    value.ifSpeed = KTCosNMS.xAGWPackage.IfSpeedEnumHelper.read (istream);
    value.ifOperStatus = KTCosNMS.xAGWPackage.OperStatusEnumHelper.read (istream);
    value.ifAdminStatus = KTCosNMS.xAGWPackage.AdminStatusEnumHelper.read (istream);
    value.ipAddress = istream.read_string ();
    value.netMask = istream.read_string ();
    value.physicalAddress = istream.read_string ();
    value.aisStatus = istream.read_long ();
    value.dscpValue = istream.read_long ();
    value.loopBackStatus = KTCosNMS.xAGWPackage.LoopBackStatusEnumHelper.read (istream);
    value.failReason = istream.read_string ();
    value.alarmStatus = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.InterfaceInfoSt value)
  {
    ostream.write_string (value.agwId);
    ostream.write_string (value.Ifid);
    KTCosNMS.xAGWPackage.IfTypeEnumHelper.write (ostream, value.ifType);
    KTCosNMS.xAGWPackage.IfSpeedEnumHelper.write (ostream, value.ifSpeed);
    KTCosNMS.xAGWPackage.OperStatusEnumHelper.write (ostream, value.ifOperStatus);
    KTCosNMS.xAGWPackage.AdminStatusEnumHelper.write (ostream, value.ifAdminStatus);
    ostream.write_string (value.ipAddress);
    ostream.write_string (value.netMask);
    ostream.write_string (value.physicalAddress);
    ostream.write_long (value.aisStatus);
    ostream.write_long (value.dscpValue);
    KTCosNMS.xAGWPackage.LoopBackStatusEnumHelper.write (ostream, value.loopBackStatus);
    ostream.write_string (value.failReason);
    ostream.write_string (value.alarmStatus);
  }

}
