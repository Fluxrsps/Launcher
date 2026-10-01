public class T
{
	static int getJavaMajorVersion(String raw)
	{
		String version = raw;
		if (version == null)
		{
			return -1;
		}

		if (version.startsWith("1."))
		{
			version = version.substring(2);
		}

		int end = 0;
		while (end < version.length() && Character.isDigit(version.charAt(end)))
		{
			++end;
		}

		if (end == 0)
		{
			return -1;
		}

		return Integer.parseInt(version.substring(0, end));
	}

	public static void main(String[] a)
	{
		String[][] cases = {
			{"1.8.0_292", "8"},
			{"1.7.0_80", "7"},
			{"9", "9"},
			{"9.0.4", "9"},
			{"11.0.31", "11"},
			{"17", "17"},
			{"17.0.19", "17"},
			{"21.0.11", "21"},
			{"21-ea", "21"},
			{"17-internal", "17"},
			{"garbage", "-1"},
		};
		int fail = 0;
		for (String[] c : cases)
		{
			int got = getJavaMajorVersion(c[0]);
			int want = Integer.parseInt(c[1]);
			boolean ok = got == want;
			if (!ok) fail++;
			System.out.println((ok ? "  ok   " : "  FAIL ") + String.format("%-14s -> %d (want %d)  isJava17=%s", c[0], got, want, got >= 17));
		}
		System.out.println(fail == 0 ? "ALL PASS" : fail + " FAILURES");
	}
}
