### Android学习记录

1. `app > java > com.example.myfirstapp > MainActivity` 主页面，App入口，打开App时会首先加载这个页面
2. `app > res > layout > activity_main.xml` 主页面布局文件
3. `app > manifests > AndroidManifest.xml` App配置文件，定义多个activity
4. `Gradle Scripts > build.gradle` 运行脚本，工程里面有一个，模块里面也有一个，可以分别配置
5. ConstraintLayout是一种布局，它基于对同级视图和父布局的约束定义每个视图的位置，可以减少嵌套布局的使用，节省UI绘制时间
6. 基线对齐而不是底部对齐，因为有些组件包含padding，底部对齐会有问题
7. 所有文字在`app > res > values > strings.xml`文件中，方便查找替换或者国际化
8. Intent 提供两个组件的运行时绑定，比如两个Activity之间。表示程序执行某项操作的意图
9. 安卓App也有沙盒机制。
10. gradle中的dependencies：
    compile类和资源会被打包到你使用的App中
    provided是指编译的时候依赖这个jar包，但是最终打包的时候不打进去。
11. 在Gradle4.1之后
    使用implementation替代compile，有别于compile的是并不能跨模块依赖。保证封装隐蔽性。
    使用compileOnly 替代 provided，用法一致
12. 安卓工程目录结构
    ActivityText：工程名称
    .gradle：gradle项目产生文件（自动编译工具产生的文件）
    .idea：IDEA项目文件（开发工具产生的文件）
    App：其中一个module，复用父项目的设置，可与父项目拥有相同的配置文件
    Build：自动构建时生成文件的地方
    Gradle：自动完成gradle环境支持文件夹
    .gitignore：git源码管理文件
    ActivityText.iml：（*.iml）IDEA项目文件
    Build.gradle：gradle项目自动编译的配置文件
    Gradle.properties：gradle运行环境配置文件
    Gradlew：自动完成gradle环境的linux mac脚本，配合gradle文件夹使用
    Gradlew.bat：自动完成gradle环境的windows脚本，配合gradle文件夹使用
    Local.properties：Android SDK、NDK环境路径配置
    Settings.gradle：gradle项目的子项目包含文件
    External Libraries：外部库
13. 安卓系统是一个多用户的Linux系统，每个App代表一个用户；每个App访问自己内部的资源时，要用到系统分发的用户id；每个进程有自己的虚拟机，每个App之间保持独立；每个App运行在自己的Linux进程中，App启动时会自动开启一个进程，关闭时系统自动结束进程。
14. Android组件是组成App的基本单元。每个组件都是一个入口，系统和用户可以通过入口进入到App里。
15. 有四种组件，Activity、Service、Broadcast receiver、Content provider，每种组件都有自己明确的意图和声明周期。
16. Activity提供页面和用户交互，每个Activity都是独立的，可以单独启动App中的每个Activity。
17. Service可以保持App运行在后台，不提供页面，activity可以启动service或者和service绑定；用户有感知的service系统会尽量保持，用户无感知的service系统可以随时清除；因为service的灵活性，系统也会用到它。
18. Broadcast receiver允许系统发送消息给App，即使App不在运行；大部分通知是来自系统的，App可以自己发送通知；通知只是进入App的方式，只能做非常少量的处理。
19. Content provider管理共享数据，可以把数据存储在文件系统中；
20. Android系统中，理论上每个App都可以启动其他App的组件，但是因为每个App都运行在独立的进程中，所以你的App不能直接启动其他App的组件，只有系统可以做到，想要启动其他App的组件要依靠系统中转。Android App没有统一入口，比如main函数。
21. 前三种组件都可以通过Intent被启动；Intent在运行时绑定各个独立的组件；对于activity和service，Intent指定要执行的操作，也可以指定要操作的数据URI，以及正在启动的组件需要知道的其他信息；对于broadcast receiver，Intent仅定义正在广播的公告；Content provider不能被Intent激活，他们只能通过Content resolver发送的请求启动；
22. startActivity(), startActivityForResult(); 
    startService(), bindService(); 
    sendBroadcast(), sendOrderedBroadcast(), sendStickyBroadcast(); 
    query();
23. 系统通过Androidmanifest.xml文件知道App中的组件存在，所以App必须在文件里面声明所有的组件；还可以声明App需要的用户权限，声明App支持的最低版本，声明App需要的软件或硬件功能，声明App需要用到的系统库或第三方库
24. Activities, services, and content providers需要在manifest文件中声明(<activity>, <service>, <receiver>, <provider>)，broadcast receiver可以在manifest文件中声明，也可以在代码中动态生成和注册
25. 通过<intent-filter>来筛选需要的组件
26. 在build.gradle中声明支持的系统SDK版本，<uses-feature>声明需要用到的系统功能
27. 安卓项目中的每个资源都会有一个唯一的数字id，可以通过id引用对应的资源（例如R.drawable.logo）；
28. res/文件夹下面的资源，animator/属性动画xml文件，anim/补间动画，color/颜色文件，drawable/位图文件，mipmap/启动图标，layout/页面布局，menu/菜单，raw/原始数据，values/字符串、数字、颜色值，xml/运行时要用的xml文件，font/字体文件
29. res/下面的资源文件夹，需要有默认文件夹，也可以添加不同文件夹适配不同机器
30. 可以用xml给资源文件起别名，不用创建不同的文件夹
31. R文件是编译后自动生成的，通过R访问资源，R.string.hello或者@string/hello，`[<package_name>.]R.<resource_type>.<resource_name>`或`@[<package_name>:]<resource_type>/<resource_name>`
32. 手机设置变化，简单页面保存状态数据并回复，复杂页面只能重新加载；需要在manifest文件中设置android:configChanges，常用的属性有orientation,screenSize,screenLayout,keyboardHidden，之后设置变化时会触发activity生命周期中的onConfigurationChanged()方法，在里面获取到最新的设置，更新页面
33. 字符串不要用硬编码，要写在string文件里，然后引用
34. string中不想翻译的字符，用 <xliff:g>标签包裹起来即可
35. 