package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/ChangeTypeEnum.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public class ChangeTypeEnum implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static KTCosNMS.xAGWPackage.ChangeTypeEnum[] __array = new KTCosNMS.xAGWPackage.ChangeTypeEnum [__size];

  public static final int _DELETE_CHANGETYPE = 0;
  public static final KTCosNMS.xAGWPackage.ChangeTypeEnum DELETE_CHANGETYPE = new KTCosNMS.xAGWPackage.ChangeTypeEnum(_DELETE_CHANGETYPE);
  public static final int _CREATE_CHANGETYPE = 1;
  public static final KTCosNMS.xAGWPackage.ChangeTypeEnum CREATE_CHANGETYPE = new KTCosNMS.xAGWPackage.ChangeTypeEnum(_CREATE_CHANGETYPE);

  public int value ()
  {
    return __value;
  }

  public static KTCosNMS.xAGWPackage.ChangeTypeEnum from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected ChangeTypeEnum (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class ChangeTypeEnum
