package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/AgwInfoStSeqHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

abstract public class AgwInfoStSeqHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/AgwInfoStSeq:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.AgwInfoSt[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.AgwInfoSt[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = KTCosNMS.xAGWPackage.AgwInfoStHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (KTCosNMS.xAGWPackage.AgwInfoStSeqHelper.id (), "AgwInfoStSeq", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static KTCosNMS.xAGWPackage.AgwInfoSt[] read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.AgwInfoSt value[] = null;
    int _len0 = istream.read_long ();
    value = new KTCosNMS.xAGWPackage.AgwInfoSt[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = KTCosNMS.xAGWPackage.AgwInfoStHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.AgwInfoSt[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      KTCosNMS.xAGWPackage.AgwInfoStHelper.write (ostream, value[_i0]);
  }

}
