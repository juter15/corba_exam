package KTCosNMS;


/**
* KTCosNMS/enSwitch.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
* 2022 10 19   6 39 28 KST
*/

public class enSwitch implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static KTCosNMS.enSwitch[] __array = new KTCosNMS.enSwitch [__size];

  public static final int _SWT_Off = 0;
  public static final KTCosNMS.enSwitch SWT_Off = new KTCosNMS.enSwitch(_SWT_Off);
  public static final int _SWT_On = 1;
  public static final KTCosNMS.enSwitch SWT_On = new KTCosNMS.enSwitch(_SWT_On);

  public int value ()
  {
    return __value;
  }

  public static KTCosNMS.enSwitch from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected enSwitch (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class enSwitch