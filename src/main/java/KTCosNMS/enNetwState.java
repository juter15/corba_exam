package KTCosNMS;


/**
* KTCosNMS/enNetwState.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public class enNetwState implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static KTCosNMS.enNetwState[] __array = new KTCosNMS.enNetwState [__size];

  public static final int _NETWSTS_Up = 0;
  public static final KTCosNMS.enNetwState NETWSTS_Up = new KTCosNMS.enNetwState(_NETWSTS_Up);
  public static final int _NETWSTS_Down = 1;
  public static final KTCosNMS.enNetwState NETWSTS_Down = new KTCosNMS.enNetwState(_NETWSTS_Down);

  public int value ()
  {
    return __value;
  }

  public static KTCosNMS.enNetwState from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected enNetwState (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class enNetwState
