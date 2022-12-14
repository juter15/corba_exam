package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/ResourceInfoStHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

abstract public class ResourceInfoStHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/ResourceInfoSt:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.ResourceInfoSt that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.ResourceInfoSt extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [4];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "systemId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[1] = new org.omg.CORBA.StructMember (
            "cpuUsage",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[2] = new org.omg.CORBA.StructMember (
            "memoryUsage",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.DiskInfoStHelper.type ();
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (KTCosNMS.xAGWPackage.DiskInfoStSeqHelper.id (), "DiskInfoStSeq", _tcOf_members0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "diskInfo",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (KTCosNMS.xAGWPackage.ResourceInfoStHelper.id (), "ResourceInfoSt", _members0);
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

  public static KTCosNMS.xAGWPackage.ResourceInfoSt read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.ResourceInfoSt value = new KTCosNMS.xAGWPackage.ResourceInfoSt ();
    value.systemId = istream.read_string ();
    value.cpuUsage = istream.read_long ();
    value.memoryUsage = istream.read_long ();
    value.diskInfo = KTCosNMS.xAGWPackage.DiskInfoStSeqHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.ResourceInfoSt value)
  {
    ostream.write_string (value.systemId);
    ostream.write_long (value.cpuUsage);
    ostream.write_long (value.memoryUsage);
    KTCosNMS.xAGWPackage.DiskInfoStSeqHelper.write (ostream, value.diskInfo);
  }

}
