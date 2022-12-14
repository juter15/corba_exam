package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/stKtAgwEMSCpuStateEventHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

abstract public class stKtAgwEMSCpuStateEventHelper
{
  private static String  _id = "IDL:KTCosNMS/xAGW/stKtAgwEMSCpuStateEvent:1.0";

  public static void insert (org.omg.CORBA.Any a, KTCosNMS.xAGWPackage.stKtAgwEMSCpuStateEvent that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static KTCosNMS.xAGWPackage.stKtAgwEMSCpuStateEvent extract (org.omg.CORBA.Any a)
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
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[2] = new org.omg.CORBA.StructMember (
            "idlePercent",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[3] = new org.omg.CORBA.StructMember (
            "usrPercent",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[4] = new org.omg.CORBA.StructMember (
            "sysPercent",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[5] = new org.omg.CORBA.StructMember (
            "ioWaitPercent",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_short);
          _members0[6] = new org.omg.CORBA.StructMember (
            "swapPercent",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[7] = new org.omg.CORBA.StructMember (
            "date",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (KTCosNMS.xAGWPackage.stKtAgwEMSCpuStateEventHelper.id (), "stKtAgwEMSCpuStateEvent", _members0);
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

  public static KTCosNMS.xAGWPackage.stKtAgwEMSCpuStateEvent read (org.omg.CORBA.portable.InputStream istream)
  {
    KTCosNMS.xAGWPackage.stKtAgwEMSCpuStateEvent value = new KTCosNMS.xAGWPackage.stKtAgwEMSCpuStateEvent ();
    value.agwEmsType = istream.read_short ();
    value.agwEmsId = istream.read_string ();
    value.idlePercent = istream.read_short ();
    value.usrPercent = istream.read_short ();
    value.sysPercent = istream.read_short ();
    value.ioWaitPercent = istream.read_short ();
    value.swapPercent = istream.read_short ();
    value.date = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, KTCosNMS.xAGWPackage.stKtAgwEMSCpuStateEvent value)
  {
    ostream.write_short (value.agwEmsType);
    ostream.write_string (value.agwEmsId);
    ostream.write_short (value.idlePercent);
    ostream.write_short (value.usrPercent);
    ostream.write_short (value.sysPercent);
    ostream.write_short (value.ioWaitPercent);
    ostream.write_short (value.swapPercent);
    ostream.write_string (value.date);
  }

}
