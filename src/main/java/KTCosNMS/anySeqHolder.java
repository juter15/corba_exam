package KTCosNMS;


/**
* KTCosNMS/anySeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
*/

public final class anySeqHolder implements org.omg.CORBA.portable.Streamable
{
  public org.omg.CORBA.Any value[] = null;

  public anySeqHolder ()
  {
  }

  public anySeqHolder (org.omg.CORBA.Any[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.anySeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.anySeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.anySeqHelper.type ();
  }

}
