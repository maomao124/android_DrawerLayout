package mao.android_drawerlayout.entity;

/**
 * Project name(项目名称)：android_DrawerLayout
 * Package(包名): mao.android_drawerlayout.entity
 * Class(类名): Item
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/8
 * Time(创建时间)： 20:23
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class Item
{
    /**
     * 图标标识
     */
    private int iconId;

    /**
     * 图标名字
     */
    private String iconName;

    /**
     * Instantiates a new Item.
     */
    public Item()
    {
    }

    /**
     * Instantiates a new Item.
     *
     * @param iconId   the icon id
     * @param iconName the icon name
     */
    public Item(int iconId, String iconName)
    {
        this.iconId = iconId;
        this.iconName = iconName;
    }


    /**
     * Gets icon id.
     *
     * @return the icon id
     */
    public int getIconId()
    {
        return iconId;
    }

    /**
     * Sets icon id.
     *
     * @param iconId the icon id
     * @return the icon id
     */
    public Item setIconId(int iconId)
    {
        this.iconId = iconId;
        return this;
    }

    /**
     * Gets icon name.
     *
     * @return the icon name
     */
    public String getIconName()
    {
        return iconName;
    }

    /**
     * Sets icon name.
     *
     * @param iconName the icon name
     * @return the icon name
     */
    public Item setIconName(String iconName)
    {
        this.iconName = iconName;
        return this;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("iconId：").append(iconId).append('\n');
        stringbuilder.append("iconName：").append(iconName).append('\n');
        return stringbuilder.toString();
    }
}
