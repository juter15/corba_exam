package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/CommonPortIdxStHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

abstract public class CommonPortIdxStHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/CommonPortIdxSt:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.CommonPortIdxSt that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.CommonPortIdxSt extract (org.omg.CORBA.Any a)
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
          _tcOf_members0 = KTCosNMS.xAGWPackage.CommonCardIdxStHelper.type ();
          _members0[0] = new org.omg.CORBA.StructMember (
            "varCommonCardIdxSt",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "portId",
            _tcOf_members0,
            null);
          _tcOf_members0 = KTCosNMS.xAGWPackage.PortTypeEnumHelper.type ();
          _members0[2] = new org.omg.CORBA.StructMember (
            "portType",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "portName",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (KTCosNMS.xAGWPackage.CommonPortIdxStHelper.id (), "CommonPortIdxSt", _members0);
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

  public static KTCosNMS.xAGWPackage.CommonPortIdxSt read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.CommonPortIdxSt value = new KTCosNMS.xAGWPackage.CommonPortIdxSt ();
    value.varCommonCardIdxSt = KTCosNMS.xAGWPackage.CommonCardIdxStHelper.read (istream);
    value.portId = istream.read_string ();
    value.portType = KTCosNMS.xAGWPackage.PortTypeEnumHelper.read (istream);
    value.portName = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.CommonPortIdxSt value)
  {
    KTCosNMS.xAGWPackage.CommonCardIdxStHelper.write (ostream, value.varCommonCardIdxSt);
    ostream.write_string (value.portId);
    KTCosNMS.xAGWPackage.PortTypeEnumHelper.write (ostream, value.portType);
    ostream.write_string (value.portName);
  }

}
