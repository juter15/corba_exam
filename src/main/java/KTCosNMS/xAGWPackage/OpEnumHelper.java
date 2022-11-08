package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/OpEnumHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
*/

abstract public class OpEnumHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/OpEnum:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.OpEnum that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.OpEnum extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_enum_tc (KTCosNMS.xAGWPackage.OpEnumHelper.id (), "OpEnum", new String[] { "STOP_OP", "START_OP", "RESTART_OP"} );
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static KTCosNMS.xAGWPackage.OpEnum read (org.omg.CORBA.portable.InputStream istream)
  {
    return KTCosNMS.xAGWPackage.OpEnum.from_int (istream.read_long ());
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.OpEnum value)
  {
    ostream.write_long (value.value ());
  }

}
