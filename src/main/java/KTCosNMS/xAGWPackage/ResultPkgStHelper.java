package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/ResultPkgStHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

abstract public class ResultPkgStHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/ResultPkgSt:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.ResultPkgSt that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.ResultPkgSt extract (org.omg.CORBA.Any a)
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
            "rackId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "shelfId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "slotId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "cardId",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.CompleteTypeEnumHelper.type ();
          _members0[5] = new org.omg.CORBA.StructMember (
            "completeType",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "bfVersion",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[7] = new org.omg.CORBA.StructMember (
            "bfPkgName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[8] = new org.omg.CORBA.StructMember (
            "upVersion",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[9] = new org.omg.CORBA.StructMember (
            "upPkgName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[10] = new org.omg.CORBA.StructMember (
            "failReason",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (KTCosNMS.xAGWPackage.ResultPkgStHelper.id (), "ResultPkgSt", _members0);
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

  public static KTCosNMS.xAGWPackage.ResultPkgSt read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.ResultPkgSt value = new KTCosNMS.xAGWPackage.ResultPkgSt ();
    value.agwId = istream.read_string ();
    value.rackId = istream.read_string ();
    value.shelfId = istream.read_string ();
    value.slotId = istream.read_string ();
    value.cardId = istream.read_string ();
    value.completeType = KTCosNMS.xAGWPackage.CompleteTypeEnumHelper.read (istream);
    value.bfVersion = istream.read_string ();
    value.bfPkgName = istream.read_string ();
    value.upVersion = istream.read_string ();
    value.upPkgName = istream.read_string ();
    value.failReason = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.ResultPkgSt value)
  {
    ostream.write_string (value.agwId);
    ostream.write_string (value.rackId);
    ostream.write_string (value.shelfId);
    ostream.write_string (value.slotId);
    ostream.write_string (value.cardId);
    KTCosNMS.xAGWPackage.CompleteTypeEnumHelper.write (ostream, value.completeType);
    ostream.write_string (value.bfVersion);
    ostream.write_string (value.bfPkgName);
    ostream.write_string (value.upVersion);
    ostream.write_string (value.upPkgName);
    ostream.write_string (value.failReason);
  }

}
