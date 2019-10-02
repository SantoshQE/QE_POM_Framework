package ObjectRepository;

public class Twitter_OR
{
    public static final String TwitterSite="https://twitter.com/login";
    //Xpaths
    //twitLoginPage
    public static final String twit_username ="//input[@name='session[username_or_email]' and @class='js-username-field email-input js-initial-focus']";
    public static final String twit_password="//input[@class='js-password-field']";
    public static final String twit_BtnLogin="//button[@class='submit EdgeButton EdgeButton--primary EdgeButtom--medium']";
    //twitEditProfilePage
    public static final String twit_BrowsePicLink="//*[@id='react-root']//div[@aria-label='Add banner photo']";
    public static final String twit_EditMediaApplyBtn="//*[@id='react-root']//div[@class='css-1dbjc4n r-obd0qt r-1pz39u2 r-1777fci r-1joea0r r-1vsu8ta r-18qmn74']/div/div/span/span[@class='css-901oao css-16my406 r-1qd0xha r-ad9z0x r-bcqeeo r-qvutc0' and contains(text(),'Apply')]";
    //twitLandingPage
    public static final String twit_HomeLink="//*[@id='react-root']//div/span[contains(text(),'Home')]";
    public static final String twit_ExploreLink="//*[@id='react-root']//div/span[contains(text(),'Explore')]";
    public static final String twit_NotificationsLink="//*[@id='react-root']//div/span[contains(text(),'Notifications')]";
    public static final String twit_MessagesLink="//*[@id='react-root']//div/span[contains(text(),'Messages')]";
    public static final String twit_BookmarksLink="//*[@id='react-root']//div/span[contains(text(),'Bookmarks')]";
    public static final String twit_ListsLink="//*[@id='react-root']//div/span[contains(text(),'Lists')]"	;
    public static final String twit_ProfileLink="//*[@id='react-root']//div/span[contains(text(),'Profile')]";
    public static final String twit_MoreLink="//*[@id='react-root']//div/span[contains(text(),'More')]";
    //twitMyProfilePage
    public static final String twit_EditProfileLink="//*[@id='react-root']//div[@class='css-1dbjc4n r-obd0qt r-18u37iz r-1w6e6rj r-1wtj0ep']//span[contains(text(),'Edit profile')]";

}

