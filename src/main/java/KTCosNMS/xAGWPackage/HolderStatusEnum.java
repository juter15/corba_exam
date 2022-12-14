package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/HolderStatusEnum.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public class HolderStatusEnum implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 6;
  private static KTCosNMS.xAGWPackage.HolderStatusEnum[] __array = new KTCosNMS.xAGWPackage.HolderStatusEnum [__size];

  public static final int _UNKNOWN_HOLDERSTATUS = 0;
  public static final KTCosNMS.xAGWPackage.HolderStatusEnum UNKNOWN_HOLDERSTATUS = new KTCosNMS.xAGWPackage.HolderStatusEnum(_UNKNOWN_HOLDERSTATUS);
  public static final int _INSTALLANDACC_HOLDERSTATUS = 1;
  public static final KTCosNMS.xAGWPackage.HolderStatusEnum INSTALLANDACC_HOLDERSTATUS = new KTCosNMS.xAGWPackage.HolderStatusEnum(_INSTALLANDACC_HOLDERSTATUS);
  public static final int _INSTALLANDNOTACC_HOLDERSTATUS = 2;
  public static final KTCosNMS.xAGWPackage.HolderStatusEnum INSTALLANDNOTACC_HOLDERSTATUS = new KTCosNMS.xAGWPackage.HolderStatusEnum(_INSTALLANDNOTACC_HOLDERSTATUS);
  public static final int _NOTINSTALLED_HOLDERSTATUS = 3;
  public static final KTCosNMS.xAGWPackage.HolderStatusEnum NOTINSTALLED_HOLDERSTATUS = new KTCosNMS.xAGWPackage.HolderStatusEnum(_NOTINSTALLED_HOLDERSTATUS);
  public static final int _MISMATCH_HOLDERSTATUS = 4;
  public static final KTCosNMS.xAGWPackage.HolderStatusEnum MISMATCH_HOLDERSTATUS = new KTCosNMS.xAGWPackage.HolderStatusEnum(_MISMATCH_HOLDERSTATUS);
  public static final int _UNAVAILABLE_HOLDERSTATUS = 5;
  public static final KTCosNMS.xAGWPackage.HolderStatusEnum UNAVAILABLE_HOLDERSTATUS = new KTCosNMS.xAGWPackage.HolderStatusEnum(_UNAVAILABLE_HOLDERSTATUS);

  public int value ()
  {
    return __value;
  }

  public static KTCosNMS.xAGWPackage.HolderStatusEnum from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected HolderStatusEnum (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class HolderStatusEnum
