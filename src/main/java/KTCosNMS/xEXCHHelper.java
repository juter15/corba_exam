package KTCosNMS;


/**
* KTCosNMS/xEXCHHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/


//--------------------------------------------------------------------------------------
abstract public class xEXCHHelper
{
  private static String  _id = "IDL:KTCosNMS/xEXCH:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xEXCH that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xEXCH extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (KTCosNMS.xEXCHHelper.id (), "xEXCH");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static KTCosNMS.xEXCH read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_xEXCHStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xEXCH value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static KTCosNMS.xEXCH narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof KTCosNMS.xEXCH)
      return (KTCosNMS.xEXCH)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      KTCosNMS._xEXCHStub stub = new KTCosNMS._xEXCHStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static KTCosNMS.xEXCH unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof KTCosNMS.xEXCH)
      return (KTCosNMS.xEXCH)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      KTCosNMS._xEXCHStub stub = new KTCosNMS._xEXCHStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
