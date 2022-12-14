package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/stKtAgwEMSHddStateEventHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

abstract public class stKtAgwEMSHddStateEventHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/stKtAgwEMSHddStateEvent:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.stKtAgwEMSHddStateEvent that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.stKtAgwEMSHddStateEvent extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [8];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[0] = new org.omg.CORBA.StructMember (
            "agwEmsType",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "agwEmsId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "fileSystemName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[3] = new org.omg.CORBA.StructMember (
            "totalSize",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[4] = new org.omg.CORBA.StructMember (
            "usedSize",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[5] = new org.omg.CORBA.StructMember (
            "freeSize",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[6] = new org.omg.CORBA.StructMember (
            "usedPercent",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[7] = new org.omg.CORBA.StructMember (
            "date",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (KTCosNMS.xAGWPackage.stKtAgwEMSHddStateEventHelper.id (), "stKtAgwEMSHddStateEvent", _members0);
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

  public static KTCosNMS.xAGWPackage.stKtAgwEMSHddStateEvent read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.stKtAgwEMSHddStateEvent value = new KTCosNMS.xAGWPackage.stKtAgwEMSHddStateEvent ();
    value.agwEmsType = istream.read_short ();
    value.agwEmsId = istream.read_string ();
    value.fileSystemName = istream.read_string ();
    value.totalSize = istream.read_long ();
    value.usedSize = istream.read_long ();
    value.freeSize = istream.read_long ();
    value.usedPercent = istream.read_short ();
    value.date = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.stKtAgwEMSHddStateEvent value)
  {
    ostream.write_short (value.agwEmsType);
    ostream.write_string (value.agwEmsId);
    ostream.write_string (value.fileSystemName);
    ostream.write_long (value.totalSize);
    ostream.write_long (value.usedSize);
    ostream.write_long (value.freeSize);
    ostream.write_short (value.usedPercent);
    ostream.write_string (value.date);
  }

}
