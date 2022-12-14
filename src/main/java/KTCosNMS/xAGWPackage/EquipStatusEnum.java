package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/EquipStatusEnum.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public class EquipStatusEnum implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 3;
  private static KTCosNMS.xAGWPackage.EquipStatusEnum[] __array = new KTCosNMS.xAGWPackage.EquipStatusEnum [__size];

  public static final int _UNKNOWN_EQUIPSTATUS = 0;
  public static final KTCosNMS.xAGWPackage.EquipStatusEnum UNKNOWN_EQUIPSTATUS = new KTCosNMS.xAGWPackage.EquipStatusEnum(_UNKNOWN_EQUIPSTATUS);
  public static final int _EQUIP_EQUIPSTATUS = 1;
  public static final KTCosNMS.xAGWPackage.EquipStatusEnum EQUIP_EQUIPSTATUS = new KTCosNMS.xAGWPackage.EquipStatusEnum(_EQUIP_EQUIPSTATUS);
  public static final int _NOTEQUIP_EQUIPSTATUS = 2;
  public static final KTCosNMS.xAGWPackage.EquipStatusEnum NOTEQUIP_EQUIPSTATUS = new KTCosNMS.xAGWPackage.EquipStatusEnum(_NOTEQUIP_EQUIPSTATUS);

  public int value ()
  {
    return __value;
  }

  public static KTCosNMS.xAGWPackage.EquipStatusEnum from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected EquipStatusEnum (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class EquipStatusEnum
