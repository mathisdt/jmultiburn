class BurnCommands
{
  static private final String[] burnType = {"audioDir","data","singleAudio","image","toc","clone"};
  static private final String[] sourceType = {"dir","any","file","file","file","dev"};
  static private final String[] burnCommand = {"-a","-d","-s","-i","-t","-c"};

  BurnCommands() {
  }

  static public String getSourceType(String s1) {
    String s2;
    int i3;
    s2 = "";
    i3 = 0;
    for (;;) {
      {
        if (i3 < burnType.length) {
          if (burnType[i3].equals(s1)) {
            s2 = sourceType[i3];
            break;
          }
        }
      }
      i3++;
    }
    return s2;
  }

  static public String getBurnCommand(String s1) {
    String s2;
    int i3;
    s2 = "";
    i3 = 0;
    for (;;) {
      {
        if (i3 < burnType.length) {
          if (burnType[i3].equals(s1)) {
            s2 = burnCommand[i3];
            break;
          }
        }
      }
      i3++;
    }
    return s2;
  }
}
