package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/GetObjectStHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

abstract public class GetObjectStHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/GetObjectSt:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.GetObjectSt that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.GetObjectSt extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [9];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = KTCosNMS.xAGWPackage.ObjectTypeEnumHelper.type ();
          _members0[0] = new org.omg.CORBA.StructMember (
            "objectType",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "emsId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "systemId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "rackId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "shelfId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "slotId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "deviceId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[7] = new org.omg.CORBA.StructMember (
            "portId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[8] = new org.omg.CORBA.StructMember (
            "ifId",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (KTCosNMS.xAGWPackage.GetObjectStHelper.id (), "GetObjectSt", _members0);
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

  public static KTCosNMS.xAGWPackage.GetObjectSt read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.GetObjectSt value = new KTCosNMS.xAGWPackage.GetObjectSt ();
    value.objectType = KTCosNMS.xAGWPackage.ObjectTypeEnumHelper.read (istream);
    value.emsId = istream.read_string ();
    value.systemId = istream.read_string ();
    value.rackId = istream.read_string ();
    value.shelfId = istream.read_string ();
    value.slotId = istream.read_string ();
    value.deviceId = istream.read_string ();
    value.portId = istream.read_string ();
    value.ifId = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.GetObjectSt value)
  {
    KTCosNMS.xAGWPackage.ObjectTypeEnumHelper.write (ostream, value.objectType);
    ostream.write_string (value.emsId);
    ostream.write_string (value.systemId);
    ostream.write_string (value.rackId);
    ostream.write_string (value.shelfId);
    ostream.write_string (value.slotId);
    ostream.write_string (value.deviceId);
    ostream.write_string (value.portId);
    ostream.write_string (value.ifId);
  }

}
