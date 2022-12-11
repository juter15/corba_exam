package KTCosNMS;


/**
* KTCosNMS/KtNMSMsgExHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/


//------------------------------------------------------------------------------------------------------
abstract public class KtNMSMsgExHelper
{
  private static String  _id = "IDL:KTCosNMS/KtNMSMsgEx:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.KtNMSMsgEx that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.KtNMSMsgEx extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [6];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[0] = new org.omg.CORBA.StructMember (
            "neType",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[1] = new org.omg.CORBA.StructMember (
            "msgType",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[2] = new org.omg.CORBA.StructMember (
            "opCode",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[3] = new org.omg.CORBA.StructMember (
            "seqNo",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "reason",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "location",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (KTCosNMS.KtNMSMsgExHelper.id (), "KtNMSMsgEx", _members0);
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

  public static KTCosNMS.KtNMSMsgEx read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.KtNMSMsgEx value = new KTCosNMS.KtNMSMsgEx ();
    // read and discard the repository ID
    istream.read_string ();
    value.neType = istream.read_short ();
    value.msgType = istream.read_short ();
    value.opCode = istream.read_long ();
    value.seqNo = istream.read_long ();
    value.reason = istream.read_string ();
    value.location = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.KtNMSMsgEx value)
  {
    // write the repository ID
    ostream.write_string (id ());
    ostream.write_short (value.neType);
    ostream.write_short (value.msgType);
    ostream.write_long (value.opCode);
    ostream.write_long (value.seqNo);
    ostream.write_string (value.reason);
    ostream.write_string (value.location);
  }

}
