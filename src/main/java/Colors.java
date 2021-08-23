public enum Colors {
    /**
     *
     */
    COLOR_WHITE ( (byte)255, (byte)255, (byte)255 ),
    COLOR_BLACK ( (byte) 0, (byte) 0, (byte) 0 ),
    COLOR_RED ( (byte) 255, (byte) 0, (byte) 0),
    COLOR_GREEN ( (byte) 0, (byte) 255, (byte) 0),
    COLOR_BLUE ( (byte) 0, (byte) 0, (byte) 255),
    COLOR_YELLOW ((byte) 255, (byte) 255, (byte) 0);
    private ColorRGB color;

    Colors(byte red, byte green, byte blue) {
        color = new ColorRGB(red, green, blue);
    }


    public ColorRGB getColor() { return this.color; }


}
