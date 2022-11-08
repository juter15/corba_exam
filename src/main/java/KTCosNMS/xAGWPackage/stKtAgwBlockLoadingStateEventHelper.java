package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/stKtAgwBlockLoadingStateEventHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

abstract public class stKtAgwBlockLoadingStateEventHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/stKtAgwBlockLoadingStateEvent:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.stKtAgwBlockLoadingStateEvent that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.stKtAgwBlockLoadingStateEvent extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [12];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[0] = new org.omg.CORBA.StructMember (
            "agwType",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "agwId",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[2] = new org.omg.CORBA.StructMember (
            "tid",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[3] = new org.omg.CORBA.StructMember (
            "ssid",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[4] = new org.omg.CORBA.StructMember (
            "oid",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[5] = new org.omg.CORBA.StructMember (
            "rid",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[6] = new org.omg.CORBA.StructMember (
            "sid",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[7] = new org.omg.CORBA.StructMember (
            "cid",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[8] = new org.omg.CORBA.StructMember (
            "lid",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[9] = new org.omg.CORBA.StructMember (
            "blockName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[10] = new org.omg.CORBA.StructMember (
            "loadingState",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[11] = new org.omg.CORBA.StructMember (
            "date",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (KTCosNMS.xAGWPackage.stKtAgwBlockLoadingStateEventHelper.id (), "stKtAgwBlockLoadingStateEvent", _members0);
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

  public static KTCosNMS.xAGWPackage.stKtAgwBlockLoadingStateEvent read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.stKtAgwBlockLoadingStateEvent value = new KTCosNMS.xAGWPackage.stKtAgwBlockLoadingStateEvent ();
    value.agwType = istream.read_short ();
    value.agwId = istream.read_string ();
    value.tid = istream.read_short ();
    value.ssid = istream.read_short ();
    value.oid = istream.read_short ();
    value.rid = istream.read_short ();
    value.sid = istream.read_short ();
    value.cid = istream.read_short ();
    value.lid = istream.read_short ();
    value.blockName = istream.read_string ();
    value.loadingState = istream.read_short ();
    value.date = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.stKtAgwBlockLoadingStateEvent value)
  {
    ostream.write_short (value.agwType);
    ostream.write_string (value.agwId);
    ostream.write_short (value.tid);
    ostream.write_short (value.ssid);
    ostream.write_short (value.oid);
    ostream.write_short (value.rid);
    ostream.write_short (value.sid);
    ostream.write_short (value.cid);
    ostream.write_short (value.lid);
    ostream.write_string (value.blockName);
    ostream.write_short (value.loadingState);
    ostream.write_string (value.date);
  }

}
