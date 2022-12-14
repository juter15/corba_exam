package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/LoopBackStatusEnumHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/


//----------------------------------------------------------------------------------
abstract public class LoopBackStatusEnumHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/LoopBackStatusEnum:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.LoopBackStatusEnum that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.LoopBackStatusEnum extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_enum_tc (KTCosNMS.xAGWPackage.LoopBackStatusEnumHelper.id (), "LoopBackStatusEnum", new String[] { "NOLOOP_LOOPBACKSTATUS", "REMOTE_LOOPBACKSTATUS", "LOCAL_LOOPBACKSTATUS"} );
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static KTCosNMS.xAGWPackage.LoopBackStatusEnum read (org.omg.CORBA.portable.InputStream istream)
  {
    return KTCosNMS.xAGWPackage.LoopBackStatusEnum.from_int (istream.read_long ());
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.LoopBackStatusEnum value)
  {
    ostream.write_long (value.value ());
  }

}
