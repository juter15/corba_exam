package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/DiskInfoStSeqHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

abstract public class DiskInfoStSeqHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/DiskInfoStSeq:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.DiskInfoSt[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.DiskInfoSt[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = KTCosNMS.xAGWPackage.DiskInfoStHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (KTCosNMS.xAGWPackage.DiskInfoStSeqHelper.id (), "DiskInfoStSeq", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static KTCosNMS.xAGWPackage.DiskInfoSt[] read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.DiskInfoSt value[] = null;
    int _len0 = istream.read_long ();
    value = new KTCosNMS.xAGWPackage.DiskInfoSt[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = KTCosNMS.xAGWPackage.DiskInfoStHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.DiskInfoSt[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      KTCosNMS.xAGWPackage.DiskInfoStHelper.write (ostream, value[_i0]);
  }

}