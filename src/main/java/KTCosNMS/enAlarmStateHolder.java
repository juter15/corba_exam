package KTCosNMS;

/**
* KTCosNMS/enAlarmStateHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022년 10월 19일 수요일 오후 6시 39분 28초 KST
*/

public final class enAlarmStateHolder implements org.omg.CORBA.portable.Streamable
{
  public KTCosNMS.enAlarmState value = null;

  public enAlarmStateHolder ()
  {
  }

  public enAlarmStateHolder (KTCosNMS.enAlarmState initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = KTCosNMS.enAlarmStateHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    KTCosNMS.enAlarmStateHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return KTCosNMS.enAlarmStateHelper.type ();
  }

}
