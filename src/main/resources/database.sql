-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `code`
--

DROP TABLE IF EXISTS `code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `code` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `item` int NOT NULL COMMENT '订单项ID',
  `uid` int NOT NULL COMMENT '用户ID',
  `code` varchar(50) NOT NULL COMMENT '激活码',
  `stat` tinyint NOT NULL DEFAULT '0' COMMENT '激活码状态，0表示未使用，1表示已使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='激活码';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code`
--

LOCK TABLES `code` WRITE;
/*!40000 ALTER TABLE `code` DISABLE KEYS */;
/*!40000 ALTER TABLE `code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(100) NOT NULL COMMENT '游戏名字',
  `gameintroduction` varchar(500) NOT NULL COMMENT '游戏描述',
  `gameabout` varchar(500) DEFAULT NULL COMMENT '游戏相关，250字以下',
  `creater` varchar(50) NOT NULL COMMENT '开发者',
  `systemcfg` varchar(500) NOT NULL COMMENT '系统推荐配置要求',
  `price` double NOT NULL COMMENT '正常价格',
  `discount` double DEFAULT NULL COMMENT '打折后价格',
  `issueddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发行时间',
  `stat` tinyint NOT NULL DEFAULT '0' COMMENT '状态，0为未上架，1为已上架，2为已下架',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='游戏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'Cold Waters','Spiritual Successor to the Microprose Classic “Red Storm Rising”.','After tracking a Soviet landing force bound for Iceland it is time to plan your attack. Do you silently close in to torpedo the landing ships and escape during the resulting chaos? Or strike with long-range missiles but risk counterattack from the enemy escorts? Have you detected them all, could another submarine be out there listening for you? Has the hunter become the hunted? Will you survive the Cold Waters?','Killerfish Games','操作系统: XP 处理器: Intel Atom\n  内存: 2 GB RAM\n  DirectX 版本: 9.0c\n  存储空间: 需要 2 GB 可用空间',58,NULL,'2021-12-07 14:04:55',0),(2,'Confess My Love','游戏发生在某一天的放学后，男生未宇打算向心仪的女生阑珊表明自己的心意，但又因为害怕被拒绝犹豫不决。','游戏发生在某一天的放学后，男生未宇打算向心仪的女生阑珊表明自己的心意，但又因为害怕被拒绝犹豫不决。\n\n要不要鼓起勇气去告白呢？\n熙轨同学为什么还不回家……？\n自己的日记可一定要放好啊，被别人看见就惨了。\n\n但这个熟悉的教室，总觉得是有什么地方不太对啊。','LR Studio','操作系统: Windows XP/ Vista/7/10\n  处理器: Intel Core 2 1.06Ghz\n  内存: 1 GB RAM\n  存储空间: 需要 50 MB 可用空间',0,NULL,'2021-12-07 14:04:55',0),(3,'Dead Cells','欢迎来到《死亡细胞》，这是一款将Roguelite与银河战士恶魔城类特点融为一炉的2D平台动作游戏。游戏中并无检查点，玩家将体验魂味战斗，一路挑战诸多守卫，在杀戮与死亡的反复轮回中探索一座房间不断变化的巨大城堡。”.','提到银河战士恶魔城类游戏，我们通常都是指一个包含多个经过悉心设计的固定相连关卡的巨大世界。游戏舞台会是一片广阔但不会发生任何变化的孤岛。其中种种生物，Boss和路线都会预先设定好，藏在这片广阔世界的某个角落等待探索。当然，如何找到他们，则是另外一个故事。\n然而，在《死亡细胞》中，死亡取代了经典银河战士恶魔城游戏反复走回头路进行探索的传统机制。起初，似乎有很多无法到达的区域散步在你前进的路途中，但随着你探索整个游戏世界的过程，这些谜题的线索会逐步揭晓。或许会是一把钥匙，或许是一种新的特殊移动技巧，或者是某种失落的技能。一旦解锁，你将永久掌握这些知识，而它们则能够助你探索游戏世界中更广阔的天地。厌倦了臭气熏天的下水道？攀上城头呼吸新鲜的空气吧！灵活运用你的技巧和游戏经验以及各种战利品来决定你前进的路线。','Motion Twin','操作系统: Windows 7+\n  处理器: Intel i5+\n  内存: 2 GB RAM\n  图形: Nvidia 450 GTS / Radeon HD 5750 or better\n  存储空间: 需要 500 MB 可用空间\n  附注事项: OpenGL 3.2+',0,NULL,'2021-12-07 14:04:55',0),(4,'EVERSPACE','《EVERSPACE™》是一款侧重于动作的单人太空射击游戏，结合了类Rogue元素和一流的视觉效果及引人入胜的故事。游戏将带领你在一个不断变化、制作精美且充满惊喜的宇宙中，展开一段富有挑战性的旅程。 你的技能、经验和随机应变的天赋都将持续受到考验；与此同时，通过遭遇其他有趣且各有奥秘的人物角色，你将了解自己的存在意义。每个回合都是激动人心的体验，每次航行都是全新的局势，让游戏的每一个部分都能长久地持续下去， 并从中创造大量独特而意味深长的体验时刻。然而，不管你的飞行技术多么高超，死亡都是不可避免的，而这只是一段更宏大旅程的开始。','《EVERSPACE™》是一款侧重于动作的单人太空射击游戏，结合了类Rogue元素和一流的视觉效果及引人入胜的故事。游戏将带领你在一个不断变化、制作精美且充满惊喜的宇宙中，展开一段富有挑战性的旅程。 你的技能、经验和随机应变的天赋都将持续受到考验；与此同时，通过遭遇其他有趣且各有奥秘的人物角色，你将了解自己的存在意义。每个回合都是激动人心的体验，每次航行都是全新的局势，让游戏的每一个部分都能长久地持续下去， 并从中创造大量独特而意味深长的体验时刻。然而，不管你的飞行技术多么高超，死亡都是不可避免的，而这只是一段更宏大旅程的开始。\n使用各种武器和装置杀入激动人心的混战，体验令人热血沸腾的太空激战。\n使用收集或开采到的资源制造装备和修改器，以在千钧一发之际占据上风，或修复你的船舰系统。全凭你选择。\n收集制造所用的设计图，搜寻奇特的武器和装备。你永远不知道接下来会捡到什么。\n一路通关程序生成的等级，闯过四伏的危机，就能斩获大量宝藏。不入虎穴，焉得虎子。\n利器已备，如何化局势为优势就看你的了。善用每一个优势，出奇不穷地扭转不利局面。有时，错一步，就会步步错。','ROCKFISH Games','操作系统: 32/64-bit Windows 7 / 8.1 / 10\n  处理器: Intel CPU Core i3\n  内存: 4 GB RAM\n  图形: Nvidia GTX 480 / AMD Radeon HD 5870\n  DirectX 版本: 10\n  存储空间: 需要 8 GB 可用空间',49.9,NULL,'2021-12-07 14:04:55',0),(5,'Lucy -The Eternity She Wished For','如果世界上有机器人能够像人一样微笑，一样哭泣，一样悲伤。','距今不久以后的未来，在人工智能科技已经普及的时代。平时对于机器人完全没有好感的主人公，突然奇遇般地捡到了一台损坏的人工智能。可那不只是普通的机器人，和那些只会重复程序设定台词的机器人不一样。这台仿佛真正人类少女一般的人工智能，会自由自在的露出笑容，袒露自己的心声…','Modern Visual Arts Laboratory','操作系统: Microsoft Windows 2000/XP(SP3)/Vista\n  处理器: Intel Pentium 4 1.5Ghz/AMD Athlon 1800\n  内存: 128 MB RAM\n  DirectX 版本: 9.0c\n  存储空间: 需要 1 GB 可用空间\n  附注事项: Microsoft .Net Framework',124,NULL,'2021-12-07 14:04:55',0),(6,'Mark of the Ninja','In Mark of the Ninja, you\'ll know what it is to truly be a ninja. You must be silent, agile and clever to outwit your opponents in a world of gorgeous scenery and flowing animation. Marked with cursed tattoos giving you heightened senses, every situation presents you with options.','In Mark of the Ninja, you\'ll know what it is to truly be a ninja. You must be silent, agile and clever to outwit your opponents in a world of gorgeous scenery and flowing animation. Marked with cursed tattoos giving you heightened senses, every situation presents you with options. Will you be an unknown, invisible ghost, or a brutal, silent assassin?','Klei Entertainment','OS:Windows XP SP3, Windows Vista SP2, Windows 7 SP1\n  Processor:AMD Phenom 9750 or Pentium D 800+\n  Memory:2 GB RAM\n  Graphics:NVIDIA® GeForce® 7800 GT or ATI Radeon™ HD 3000+ or better DirectX®:9.0c\n  Hard Drive:2.5 GB\n  HD space Sound:100% DirectX9.0c compatible sound card and drivers',66,NULL,'2021-12-07 14:04:55',0),(7,'Oxygen Not Included','《缺氧》 是一款太空殖民模拟游戏。 在外太空岩深处，你手下的勤劳开拓者们需要熟练掌握科技，战胜新的陌生生命形式，以及利用难以置信的太空技术来生存。甚至，还有可能繁荣起来。','在这款太空殖民模拟游戏《缺氧》中，你会发现氧气、温度和营养的不足都会持续对你的新大陆造成生存威胁。引导你的开拓者穿过极具危险的活体小行星地底，观察他们人口的增长，让他们不仅仅是简单的生存下来， 而是繁荣起来...\n但是要确保你没有忘记要呼吸！\n建立广阔的基地以及探索生存所需的资源:\n从挖掘、资源分配到管道、电力系统，太空新大陆的一切都在你的掌控之下。然而，资源会从你第一次呼吸开始被消耗 ，所以如果你想生存下来的话，就一定要确保你探索得够快。\n用复杂的气体和液体模拟系统来提高效率:\n建立一个连锁的管道系统，可以迅速的将燃料和液体输送到基地的关键区域。优质的规划以及获得的加成可以让你的新大陆转变成一个运转良好的不朽机器。\n通过电网模拟系统来获得电力:\n你可以通过众多不同的能源来获得电力，包括煤，氢，天然气或者仅仅是朴实老旧的油脂。修复电力流失，电路过载和崩溃问题以保持你新大陆的顺利运行。\n通过极致的回收来保证不浪费任何资源:\n确保你为基地用尽所有的资源，以体现它们真正的效能。把回收的废物变成宝贵的燃料、不能呼吸的气体变成空气或者培养野生生物作为食物。\n','Klei Entertainment','操作系统: Windows 7 (64 bit)\n  处理器: Dual Core 2 GHz\n  内存: 4 GB RAM\n  图形: Intel HD 4600 (AMD or NVIDIA equivalent)\n  DirectX 版本: 11\n  存储空间: 需要 2 GB 可用空间',76,NULL,'2021-12-07 14:04:55',0),(8,'Stardew Valley','你继承了你爷爷在星露谷留下的老旧农场。带着爷爷留下的残旧工具和几枚硬币开始了你的新生活。你能适应这小镇上的生活并且将这个杂草丛生的老旧农场变成一个繁荣的家吗？','你继承了你爷爷在星露谷留下的老旧农场。带着爷爷留下的残旧工具和几枚硬币开始了你的新生活。你能适应这小镇上的生活并且将这个杂草丛生的老旧农场变成一个繁荣的家吗？这不是一件容易的事情。尤其是当Joja企业进驻镇上，导致以前旧的生活方式都消失了。交流中心这个以前举办过众多活动并充满活力的地方现在变成再也无人愿意踏进的一片废墟。但这山谷似乎充满机会，只要做出一点奉献你就可能是会成为让星露谷重回繁荣的人之一！','ConcernedApe','操作系统: Windows Vista or greater\n  处理器: 2 Ghz\n  内存: 2 GB RAM\n  图形: 256 mb video memory, shader model 3.0+\n  DirectX 版本: 10\n  存储空间: 需要 500 MB 可用空间',21,NULL,'2021-12-07 14:04:55',0),(9,'The Witness','你孤身一人醒来。这是一座充满挑战和惊奇、遍地谜题的奇怪小岛。','你孤身一人醒来。这是一座充满挑战和惊奇、遍地谜题的奇怪小岛。\n\n你不记得你是谁，也不知道是怎样来到这里；唯一你可以做的就是：探索这座小岛，希望能找到一些线索，重拾记忆并找到回家的方法。\n\nThe Witness 是一个单人游戏，你需要在拥有数十个地域和超过 500 个谜题的开放世界中进行探索和解谜。你是一位聪明的玩家，这个游戏不愿浪费你的时间。不存在需要填充的容器；各种谜题都会将新的想法添入整体。所以，这是一个充满了想法的游戏。','Thekla, Inc.','操作系统: Windows 7\n  处理器: 1.8GHz\n  内存: 4 GB RAM\n  图形: Intel HD 4000 series\n  DirectX 版本: 10\n  存储空间: 需要 5 GB 可用空间',21,NULL,'2021-12-07 14:04:55',0),(10,'Aeon','伊恩，一位掌控“时间”的古希腊战神在虚拟世界里复活！强调“身体慢动作躲避”的技巧。灵感来自于《黑客帝国》和《死侍》，（记得你动的越慢时间越慢）ps.困难模式才是本体！','突如其来的星际浩劫，地球惨遭不明大型宇宙射线攻击燃烧殆尽，所有太阳系行星失去引力，脱离原本稳定的轨道向外太空飞行，地球进入无日照环境。1年后除火山口与海洋深处的生命，其他均已死去。这时一艘超越地球文明的神秘战舰闪现，悬浮在地球的新飞行轨道上空，这就是《奥丁号》。在引力盾的保护下生命雷达反馈地球已无人类迹象。残存在这篇寂静中，战斗意识活跃且优等的生命意识波信号被《奥丁号》的量子吸收器采集。\n这一次，玩家将扮演万千战斗意识之一，伊恩的元神，获得重生，在虚拟与现实世界中找回真我！\n','Illusion Ranger','操作系统: win7\n处理器: intel i5\n内存: 8000 MB RAM\n图形: Nvidia 970\nDirectX 版本: 11\n存储空间: 需要 2000 MB 可用空间\n附注事项: HTC vive only',55,NULL,'2021-12-07 14:04:55',0),(11,'Alien Swarm Reactive Drop','一款免费的第三人称上帝视角射击游戏。在面对凶猛的外星虫群下，IAF小队将使用不同等级的武器装备，运用各种混合战术去消灭它们。','《Alien Swarm: Reactive Drop》是《Alien Swarm》的扩展包。此Mod在原游戏的基础上增添了更多的地图，外星虫群，游戏模式，枪械物品等…… 并且支持Steam创意工坊。\n\n充满战略合作的8人射击游戏并使用第三人称上帝视角\nSteam创意工坊支持玩家自制地图和挑战\n增添了许多新的合作地图\n新增挑战（游戏模式）：由官方或玩家自制新添的模式\n新增PvP模式：死亡竞赛，枪械游戏，一击必杀以及团队死亡竞赛\n增加单人模式：在任意官方地图中与带有增强属性的机器人一起作战\n新的外星虫群：半条命2蚁狮守卫以及其他\n新武器：沙漠之鹰，毁灭者霰弹枪，战斗步枪等\n新增成就：超过100个Steam成就可获取\n排行榜系统: 与好友或全世界玩家竞速（任务完成时间）\n旁观者优化：实时观看被旁观者的鼠标移动轨迹','Reactive Drop Team','操作系统: Windows® XP or above\n处理器: Pentium 4 3.0GHz\n内存: 2 GB RAM\n图形: DirectX 9 compatible video card with 128 MB, Shader model 2.0. ATI X800, NVidia 6600 or better\nDirectX 版本: 9.0\n存储空间: 需要 10 GB 可用空间\n声卡: DirectX 9.0c compatible sound card',76,NULL,'2021-12-07 14:04:55',0),(12,'Counter-Strike Global Offensive','《反恐精英：全球攻势》（CS: GO）延续了 1999 年原作在团队竞技类游戏上取得的成就。 CS: GO 的特色包含全新的地图、人物、武器、全新的游戏模式，并提供翻新后的 CS 经典内容（de_dust2 等）。','《反恐精英：全球攻势》（CS: GO）延续了 1999 年原作在团队竞技类游戏上取得的傲人成就。\n\nCS: GO 的特色包含全新的地图、人物、武器、全新的游戏模式，并提供翻新后的 CS 经典内容（de_dust2 等）。\n\n“《反恐精英》这个模组于 1999 年 8月推出时，立刻成了世界上玩家数量最多的线上 PC 动作游戏，使得游戏业为之一惊。”Valve 的 Doug Lombardi 如是说道。“在过去的 12 年中，它一直是世界上拥有玩家数量最多的游戏之一，引领着竞技游戏赛事，并且在全球创下了超过 2500 万套的游戏销量。CS: GO 承诺将增强屡获殊荣的 CS 系列之游戏体验，并把它带给 PC 平台、次世代主机平台和 Mac 平台的玩家。”','Valve','操作系统: Windows® 7/Vista/XP\n处理器: Intel® Core™ 2 Duo E6600 or AMD Phenom™ X3 8750 processor or better\n内存: 2 GB RAM\n图形: Video card must be 256 MB or more and should be a DirectX 9-compatible with support for Pixel Shader 3.0\nDirectX 版本: 9.0c\n存储空间: 需要 15 GB 可用空间',58,NULL,'2021-12-07 14:04:55',0),(13,'Football Manager 2017','作为迄今为止最真实的足球经理类游戏，Football Manager 2017 让你操控自己最喜欢的球队征战绿茵赛场。',NULL,'Sports Interactive','操作系统: Windows Vista (SP2), 7 (SP1), 8, 8.1, 10 (1607) – 64-bit or 32-bit\n处理器: Intel Pentium 4, Intel Core or AMD Athlon – 2.2 GHz +\n内存: 2 GB RAM\n图形: Intel GMA X3100, NVIDIA GeForce 8600M GT or AMD/ATI Mobility Radeon HD 2400 – 256MB VRAM\nDirectX 版本: 9.0c\n存储空间: 需要 3 GB 可用空间',75,NULL,'2021-12-07 14:04:55',0),(14,'Marvel\'s Guardians of the Galaxy The Telltale Series','从地球到米兰号再到不毛之地以及更远的地方，伴随着超棒的音乐节奏，这个分为五章节的系列游戏将带你进入穿着火箭靴的星爵的全新Guardians历险。游戏故事由曾获奖的Telltale独特风格讲述，你的选择和动作将决定你所体验的故事轨迹。 ',NULL,'Telltale Games','操作系统: Windows 7 64Bit Service Pack 1 or higher\n处理器: Intel Core 2 Duo 2.4GHz\n内存: 3 GB RAM\n图形: Nvidia GTS 450+ with 1024MB+ VRAM (excluding GT)\nDirectX 版本: 11\n存储空间: 需要 15 GB 可用空间\n声卡: Direct X 11 sound device',198,NULL,'2021-12-07 14:04:55',0),(15,'PLAYERUNKNOWN\'S BATTLEGROUNDS','绝地求生(PLAYERUNKNOWN’S BATTLEGROUNDS)是大逃杀类型的游戏，每一局游戏将有100名玩家参与，他们将被投放在绝地岛(battlegrounds)的上空，游戏开始跳伞时所有人都一无所有。',NULL,'Bluehole, Inc.','操作系统: 64-bit Windows 7, Windows 8.1, Windows 10\n处理器: Intel Core i3-4340 / AMD FX-6300\n内存: 6 GB RAM\n图形: nVidia GeForce GTX 660 2GB / AMD Radeon HD 7850 2GB\nDirectX 版本: 11\n网络: 宽带互联网连接\n存储空间: 需要 30 GB 可用空间',200,NULL,'2021-12-07 14:04:55',0),(16,'Portal Knights','将熟悉的世界抛在身后，踏入 Portal Knights 这个奇妙的未知世界！在由古代传送门连接的众多沙盒岛屿上，和你的好友一起展开这场惊险刺激的制作冒险。没有人记得自从和平的世界因为碎裂分崩离析、陷入黑暗之后已经过了多久。是否还有勇者敢于将这片破碎之地复原？打造你的冒险之旅。',NULL,'Keen Games','操作系统: 64bit Versions of Windows 7, Windows 8, Windows 10\n处理器: AMD Phenom(tm) 8450 Triple-Core Processor (3 CPUs), ~2.1GHz or Intel Core 2 Duo E8400 @ 3.0 GHz\n内存: 4 GB RAM\n图形: Graphics: NVIDIA® GeForce GTX 470 (1Gb VRAM) / ATI Radeon TM HD 6870 (1Gb VRAM)\nDirectX 版本: 11\n网络: 宽带互联网连接\n存储空间: 需要 2 GB 可用空间\n声卡: On Board',98,NULL,'2021-12-07 14:04:55',0),(17,'Prey','In Prey, you awaken aboard Talos I, a space station orbiting the moon in the year 2032. You are the key subject of an experiment meant to alter humanity forever – but things have gone terribly wrong. The space station has been overrun by hostile aliens and you are now being hunted. ',NULL,'Arkane Studios','操作系统: Windows 7/8/10 (64-bit versions)\n处理器: Intel i5-2400, AMD FX-8320\n内存: 8 GB RAM\n图形: GTX 660 2GB, AMD Radeon 7850 2GB\n存储空间: 需要 20 GB 可用空间',79,NULL,'2021-12-07 14:04:55',0),(18,'Steel Division Normandy 44','Steel Division: Normandy is a tactical real-time strategy (RTS) game that pits players against AI enemies in a single-player campaign -- or against several opponents in massive 10-on-10 multiplayer battles. ',NULL,'Eugen Systems','操作系统: 64-bit Windows 10 / 8.1 / 7 with Service Pack 1\n处理器: Intel Core i3-2100 (3.1 GHz) or equivalent\n内存: 3 GB RAM\n图形: 1 GB AMD 5570 or nVidia 450\nDirectX 版本: 11\n网络: 宽带互联网连接\n存储空间: 需要 32 GB 可用空间\n声卡: DirectX Compatible Sound Card',66,NULL,'2021-12-07 14:04:55',0),(19,'THE KING OF FIGHTERS XIII STEAM EDITION','“THE KING OF FIGHTERS XIII”, SNK PLAYMORE’s flagship 2D versus fighting title returns in an ultimate version on Steam!!The many features exclusive to the console version of the game, such as the ONLINE Mode that allows you to enjoy smooth online versus matches with rivals from around the world',NULL,'SNK Playmore','操作系统: Windows XP\n处理器: Intel Pentium4 2.0 GHz and up\n内存: 1 GB RAM\n图形: GeForce 9500 GT ,VRAM: 256MB and up\nDirectX 版本: 9.0c\n存储空间: 需要 5 GB 可用空间\n声卡: DirectSound, DirectX9.0c Compatible Audio',50,NULL,'2021-12-07 14:04:55',0),(20,'GTA Online: Shark Cash Cards','该内容需要在 Steam 拥有基础游戏 Grand Theft Auto V 才能运行。',NULL,'Rockstar North','操作系统: Windows 10 64 Bit, Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack 1, Windows Vista 64 Bit Service Pack 2* (*NVIDIA video card recommended if running Vista OS)\n处理器: Intel Core 2 Quad CPU Q6600 @ 2.40GHz (4 CPUs) / AMD Phenom 9850 Quad-Core Processor (4 CPUs) @ 2.5GHz\n内存: 4 GB RAM\n图形: NVIDIA 9800 GT 1GB / AMD HD 4870 1GB (DX 10, 10.1, 11)\n存储空间: 需要 72 GB 可用空间\n声卡: 100% DirectX 10 compatible',148,NULL,'2021-12-07 14:04:55',0),(21,'ABZU','沿袭 Journey蕴含的艺术思想，ABZU 是一款能唤起潜水梦想的唯美海底冒险游戏。深入海洋中心，将自己沉浸在生机勃勃的隐秘世界中，这里色彩缤纷，生物繁多。但要注意，当你不断深入，危险就潜伏在深处。',NULL,'Giant Squid','操作系统: Windows 7, 64-bit\n处理器: 3.0GHz CPU Dual Core\n内存: 4 GB RAM\n图形: Geforce GTX 750 / Radeon R7 260X\nDirectX 版本: 11\n存储空间: 需要 6 GB 可用空间\n声卡: DirectX compatible sound card',68,NULL,'2021-12-07 14:04:55',0),(22,'Alvora Tactics','Alvora Tactics is an indie Tactics RPG that combines strategic combat with immersive exploration. Explore and conquer Great Serpent Alvora with your own customizable band of warriors!',NULL,'Rad Codex','操作系统: Windows XP\n内存: 1 GB RAM\n图形: Must support Shader Model 2.0\nDirectX 版本: 9.0c\n存储空间: 需要 1000 MB 可用空间',32,NULL,'2021-12-07 14:04:55',0),(23,'DiRT 4','世界领先的越野赛系列游戏回归了！《DiRT 4》让你驾驶有史以来最强的赛车去面对这个星球的拉力赛、rallycross 和 landrush 中危险重重的赛道。游戏改变了“你的赛段”系统，只要轻轻触摸一个按钮，即可创建无数条赛道。',NULL,'Codemasters','操作系统: 64bit Versions of Windows 7, Windows 8, Windows 10\n处理器: AMD FX Series or Intel Core i3 Series\n内存: 4 GB RAM\n图形: AMD HD5570 or NVIDIA GT440 with 1GB of VRAM (DirectX 11 graphics card required)\n网络: 宽带互联网连接\n存储空间: 需要 50 GB 可用空间\n声卡: DirectX Compatible soundcard',158,NULL,'2021-12-07 14:04:55',0),(24,'DARK SOULS III','Dark Souls即将推出极具话题性及代表性的系列新作。',NULL,'FromSoftware, Inc.','操作系统: Windows 7 SP1 64bit, Windows 8.1 64bit Windows 10 64bit\n处理器: Intel Core i3-2100 / AMD® FX-6300\n内存: 4 GB RAM\n图形: NVIDIA® GeForce GTX 750 Ti / ATI Radeon HD 7950\nDirectX 版本: 11\n网络: 宽带互联网连接\n存储空间: 需要 25 GB 可用空间\n声卡: DirectX 11 sound device',268,NULL,'2021-12-07 14:04:55',0),(25,'Kung Fury','Miami Police Department detective and martial artist Kung Fury time travels from the 1980s to World War II to kill Adolf Hitler, a.k.a. \"Kung Führer\", and revenge his friend\'s death at the hands of the Nazi leader. An error in the time machine sends him further back to the Viking Age.',NULL,'Laser Unicorns','操作系统: Windows 7\n处理器: 英特尔酷睿 2 处理器或相同性能的 AMD 处理器\n内存: 1 GB RAM\n网络: 宽带互联网连接\n存储空间: 需要 200 MB 可用空间',0,NULL,'2021-12-07 14:04:55',0),(26,'Grand Theft Auto V','A young street hustler, a retired bank robber and a terrifying psychopath must pull off a series of dangerous heists to survive in a ruthless city in which they can trust nobody, least of all each other.',NULL,'Rockstar North','操作系统: Windows 10 64 Bit, Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack 1, Windows Vista 64 Bit Service Pack 2* (*NVIDIA video card recommended if running Vista OS)\n处理器: Intel Core 2 Quad CPU Q6600 @ 2.40GHz (4 CPUs) / AMD Phenom 9850 Quad-Core Processor (4 CPUs) @ 2.5GHz\n内存: 4 GB RAM\n图形: NVIDIA 9800 GT 1GB / AMD HD 4870 1GB (DX 10, 10.1, 11)\n存储空间: 需要 72 GB 可用空间\n声卡: 100% DirectX 10 compatible',198,NULL,'2021-12-07 14:04:55',0),(27,'Tree of Savior (English Ver.)','Tree of Savior(abbreviated as TOS thereafter) is an MMORPG in which you embark on a journey to search for the goddesses in the world of chaos. Fairy-tale like colors accompanied with beautiful graphics in TOS will have you reminiscing about precious moments all throughout the game.',NULL,'IMCGAMES Co.,Ltd.','操作系统: Windows XP\n处理器: Intel Pentium Core 2\n内存: 4 GB RAM\n图形: NVIDIA Geforce 8600\nDirectX 版本: 9.0c\n网络: 宽带互联网连接\n存储空间: 需要 4 GB 可用空间',0,NULL,'2021-12-07 14:04:55',0),(28,'H1Z1 King of the Kill','《杀戮之王》是一款单败淘汰制多人在线射击游戏，可容纳150名身经百战的玩家角逐于一个强大而复杂的世界。搜寻武器、弹药、盔甲、车辆和补给，在竞争中脱颖而出，并坚持到最后。',NULL,'Daybreak Game Company','操作系统: Windows 7, 8, 8.1, 10 (64 bit only)\n处理器: Intel i5 Quad-Core\n内存: 6 GB RAM\n图形: nVidia GeForce GTX 280 series or higher\nDirectX 版本: 10\n网络: 宽带互联网连接\n存储空间: 需要 20 GB 可用空间\n声卡: DirectX Compatible Sound Card',68,NULL,'2021-12-07 14:04:55',0),(29,'F1 2016','在F1 2016中创造您自己的传奇。准备好全身心投入这场有史以来最著名的顶尖赛车赛事中。与您的代理人、工程师与团队共同合作，以十个赛季的丰富经验深度开发您的赛车。',NULL,'Codemasters ,	Feral Interactive (Mac)','操作系统: 64bit Versions of Windows 7, Windows 8, Windows 10\n处理器: Intel Core i3 530 or AMD FX 4100\n内存: 8 GB RAM\n图形: Nvidia GTX 460 or AMD HD 5870\nDirectX 版本: 11\n网络: 宽带互联网连接\n存储空间: 需要 30 GB 可用空间\n声卡: DirectX Compatible Soundcard',158,NULL,'2021-12-07 14:04:55',0),(30,'ELEX','ELEX is a handcrafted action role-playing experience from the award-winning creators of the Gothic series, set in a brand new post-apocalyptic Science Fantasy universe that puts players into a huge seamless game world full of original characters, mutated creatures, deep moral choices and powerful action.',NULL,'Piranha Bytes','操作系统: Windows 7, 8, Windows 10 (64 bit)\n处理器: Intel Core i5 at 2.5 GHz or better or AMD Phenom II x4 940 at 3.0 GHz\n内存: 6 GB RAM\n图形: NVIDIA GeForce GTX 570 or AMD Radeon HD 5870, 1 GB VRAM\nDirectX 版本: 11\n存储空间: 需要 20 GB 可用空间\n声卡: DirectX compatible Sound card',44.1,NULL,'2021-12-07 14:04:55',0),(31,'Friday the 13th: The Game','Jason is back! Jason Voorhees is unleashed and stalking the grounds of Camp Crystal Lake! Friday the 13th: The Game is one of the most highly-anticipated horror titles of all time. You will finally be able to take on the role as Jason Voorhees and Camp Crystal Lake counselors.',NULL,'IllFonic','操作系统: Windows 7, Windows 8, Windows 10\n处理器: Intel Core i3-530 (2 * 2930), AMD Athlon II X2 270 (2 * 3400)\n内存: 4096 MB RAM\n图形: GeForce GTX 650 Ti (1024 MB), Radeon HD 7770 (1024 MB)\nDirectX 版本: 11\n网络: 宽带互联网连接\n存储空间: 需要 4 GB 可用空间',39,NULL,'2021-12-07 14:04:55',0);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `img`
--

DROP TABLE IF EXISTS `img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `img` (
  `game` int NOT NULL COMMENT '游戏ID',
  `img` varchar(50) NOT NULL COMMENT '图片路径'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏图片映射表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `img`
--

LOCK TABLES `img` WRITE;
/*!40000 ALTER TABLE `img` DISABLE KEYS */;
INSERT INTO `img` VALUES (1,'/1/header.jpg'),(1,'/1/1.jpg'),(1,'/1/2.jpg'),(1,'/1/3.jpg'),(1,'/1/4.jpg'),(1,'/1/5.jpg'),(2,'/2/header.jpg'),(2,'/2/1.jpg'),(2,'/2/2.jpg'),(2,'/2/3.jpg'),(2,'/2/4.jpg'),(2,'/2/5.jpg'),(3,'/3/header.jpg'),(3,'/3/1.jpg'),(3,'/3/2.jpg'),(3,'/3/3.jpg'),(3,'/3/4.jpg'),(3,'/3/5.jpg'),(4,'/4/header.jpg'),(4,'/4/1.jpg'),(4,'/4/2.jpg'),(4,'/4/3.jpg'),(4,'/4/4.jpg'),(4,'/4/5.jpg'),(5,'/5/header.jpg'),(5,'/5/1.jpg'),(5,'/5/2.jpg'),(5,'/5/3.jpg'),(5,'/5/4.jpg'),(5,'/5/5.jpg'),(6,'/6/header.jpg'),(6,'/6/1.jpg'),(6,'/6/2.jpg'),(6,'/6/3.jpg'),(6,'/6/4.jpg'),(6,'/6/5.jpg'),(7,'/7/header.jpg'),(7,'/7/1.jpg'),(7,'/7/2.jpg'),(7,'/7/3.jpg'),(7,'/7/4.jpg'),(7,'/7/5.jpg'),(7,'/7/6.jpg'),(8,'/8/header.jpg'),(8,'/8/1.jpg'),(8,'/8/2.jpg'),(8,'/8/3.jpg'),(8,'/8/4.jpg'),(8,'/8/5.jpg'),(9,'/9/header.jpg'),(9,'/9/1.jpg'),(9,'/9/2.jpg'),(9,'/9/3.jpg'),(9,'/9/4.jpg'),(9,'/9/5.jpg'),(10,'/10/header.jpg'),(10,'/10/1.jpg'),(10,'/10/2.jpg'),(10,'/10/3.jpg'),(10,'/10/4.jpg'),(10,'/10/5.jpg'),(10,'/10/6.jpg'),(11,'/11/header.jpg'),(11,'/11/1.jpg'),(11,'/11/2.jpg'),(11,'/11/3.jpg'),(11,'/11/4.jpg'),(11,'/11/5.jpg'),(11,'/11/6.jpg'),(12,'/12/header.jpg'),(12,'/12/1.jpg'),(12,'/12/2.jpg'),(12,'/12/3.jpg'),(12,'/12/4.jpg'),(12,'/12/5.jpg'),(12,'/12/6.jpg'),(13,'/13/header.jpg'),(13,'/13/1.jpg'),(13,'/13/2.jpg'),(13,'/13/3.jpg'),(13,'/13/4.jpg'),(13,'/13/5.jpg'),(13,'/13/6.jpg'),(14,'/14/header.jpg'),(14,'/14/1.jpg'),(14,'/14/2.jpg'),(14,'/14/3.jpg'),(14,'/14/4.jpg'),(14,'/14/5.jpg'),(15,'/15/header.jpg'),(15,'/15/1.jpg'),(15,'/15/2.jpg'),(15,'/15/3.jpg'),(15,'/15/4.jpg'),(15,'/15/5.jpg'),(16,'/16/header.jpg'),(16,'/16/1.jpg'),(16,'/16/2.jpg'),(16,'/16/3.jpg'),(16,'/16/4.jpg'),(16,'/16/5.jpg'),(16,'/16/6.jpg'),(17,'/17/header.jpg'),(17,'/17/1.jpg'),(17,'/17/2.jpg'),(17,'/17/3.jpg'),(17,'/17/4.jpg'),(17,'/17/5.jpg'),(17,'/17/6.jpg'),(18,'/18/header.jpg'),(18,'/18/1.jpg'),(18,'/18/2.jpg'),(18,'/18/3.jpg'),(18,'/18/4.jpg'),(18,'/18/5.jpg'),(18,'/18/6.jpg'),(19,'/19/header.jpg'),(19,'/19/1.jpg'),(19,'/19/2.jpg'),(19,'/19/3.jpg'),(19,'/19/4.jpg'),(19,'/19/5.jpg'),(20,'/20/header.jpg'),(20,'/20/1.jpg'),(20,'/20/2.jpg'),(20,'/20/3.jpg'),(20,'/20/4.jpg'),(20,'/20/5.jpg'),(21,'/21/header.jpg'),(21,'/21/1.jpg'),(21,'/21/2.jpg'),(21,'/21/3.jpg'),(21,'/21/4.jpg'),(21,'/21/5.jpg'),(21,'/21/6.jpg'),(22,'/22/header.jpg'),(22,'/22/1.jpg'),(22,'/22/2.jpg'),(22,'/22/3.jpg'),(22,'/22/4.jpg'),(22,'/22/5.jpg'),(23,'/23/header.jpg'),(23,'/23/1.jpg'),(23,'/23/2.jpg'),(23,'/23/3.jpg'),(23,'/23/4.jpg'),(23,'/23/5.jpg'),(24,'/24/header.jpg'),(24,'/24/1.jpg'),(24,'/24/2.jpg'),(24,'/24/3.jpg'),(24,'/24/4.jpg'),(24,'/24/5.jpg'),(25,'/25/header.jpg'),(25,'/25/1.jpg'),(25,'/25/2.jpg'),(25,'/25/3.jpg'),(25,'/25/4.jpg'),(25,'/25/5.jpg'),(26,'/26/header.jpg'),(26,'/26/1.jpg'),(26,'/26/2.jpg'),(26,'/26/3.jpg'),(26,'/26/4.jpg'),(26,'/26/5.jpg'),(27,'/27/header.jpg'),(27,'/27/1.jpg'),(27,'/27/2.jpg'),(27,'/27/3.jpg'),(27,'/27/4.jpg'),(27,'/27/5.jpg'),(28,'/28/header.jpg'),(28,'/28/1.jpg'),(28,'/28/2.jpg'),(28,'/28/3.jpg'),(28,'/28/4.jpg'),(28,'/28/5.jpg'),(29,'/29/header.jpg'),(29,'/29/1.jpg'),(29,'/29/2.jpg'),(29,'/29/3.jpg'),(29,'/29/4.jpg'),(29,'/29/5.jpg'),(30,'/30/header.jpg'),(30,'/30/1.jpg'),(30,'/30/2.jpg'),(30,'/30/3.jpg'),(30,'/30/4.jpg'),(30,'/30/5.jpg'),(30,'/30/6.jpg'),(31,'/31/header.jpg'),(31,'/31/1.jpg'),(31,'/31/2.jpg'),(31,'/31/3.jpg'),(31,'/31/4.jpg'),(31,'/31/5.jpg'),(31,'/31/6.jpg');
/*!40000 ALTER TABLE `img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kind`
--

DROP TABLE IF EXISTS `kind`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kind` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '种类ID',
  `name` varchar(10) NOT NULL COMMENT '种类名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='游戏种类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kind`
--

LOCK TABLES `kind` WRITE;
/*!40000 ALTER TABLE `kind` DISABLE KEYS */;
INSERT INTO `kind` VALUES (1,'独立'),(2,'动作'),(3,'冒险'),(4,'休闲'),(5,'策略'),(6,'模拟'),(7,'角色扮演'),(8,'免费'),(9,'单人'),(10,'大型多人在线'),(11,'射击'),(12,'体育'),(13,'氛围'),(14,'暴力');
/*!40000 ALTER TABLE `kind` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kindmapper`
--

DROP TABLE IF EXISTS `kindmapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kindmapper` (
  `game` int NOT NULL COMMENT '游戏ID',
  `kind` int NOT NULL COMMENT '游戏种类ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏-种类详情项映射表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kindmapper`
--

LOCK TABLES `kindmapper` WRITE;
/*!40000 ALTER TABLE `kindmapper` DISABLE KEYS */;
INSERT INTO `kindmapper` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,3),(21,4),(22,5),(23,6),(24,7),(25,8),(26,9),(27,10),(28,11),(29,12),(30,13),(31,14);
/*!40000 ALTER TABLE `kindmapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uid` int NOT NULL COMMENT '购买者ID',
  `price` double NOT NULL DEFAULT '0' COMMENT '订单总价',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `stat` tinyint NOT NULL DEFAULT '0' COMMENT '订单状态，0为未支付，1为已支付，2为取消订单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderitem` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `gid` int NOT NULL COMMENT '游戏id',
  `price` double NOT NULL COMMENT '购买时价格',
  `code` int DEFAULT NULL COMMENT '激活码',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='每个订单对应的订单详细内容';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordermapper`
--

DROP TABLE IF EXISTS `ordermapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordermapper` (
  `order` int NOT NULL COMMENT '订单ID',
  `item` int NOT NULL COMMENT '订单详情ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单-订单详情项映射表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordermapper`
--

LOCK TABLES `ordermapper` WRITE;
/*!40000 ALTER TABLE `ordermapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordermapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saletable`
--

DROP TABLE IF EXISTS `saletable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saletable` (
  `gameid` int NOT NULL,
  `salenum` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saletable`
--

LOCK TABLES `saletable` WRITE;
/*!40000 ALTER TABLE `saletable` DISABLE KEYS */;
/*!40000 ALTER TABLE `saletable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoppingcart` (
  `id` int NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gameprice` int NOT NULL DEFAULT '0',
  `gamename` varchar(255) DEFAULT NULL,
  `gameid` bigint DEFAULT NULL,
  `discount` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcart`
--

LOCK TABLES `shoppingcart` WRITE;
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `name` varchar(10) NOT NULL COMMENT '标签名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='游戏标签表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'模拟'),(2,'独立'),(3,'海军'),(4,'策略'),(5,'冷战'),(6,'免费'),(7,'冒险'),(8,'角色扮演'),(9,'日本动画'),(10,'动作'),(11,'太空'),(12,'科幻'),(13,'单人'),(14,'剧情'),(15,'机器人'),(16,'潜行'),(17,'忍者'),(18,'多人'),(19,'二维'),(20,'建筑建造'),(21,'生存'),(22,'农业'),(23,'工业'),(24,'解密'),(25,'探索'),(26,'第一人称'),(27,'射击'),(28,'虚拟现实'),(29,'合作'),(30,'外星人'),(31,'体育'),(32,'足球'),(33,'恐怖'),(34,'即时战略'),(35,'街机'),(36,'格斗'),(37,'竞速'),(38,'困难'),(39,'女主人翁'),(40,'丧尸'),(41,'氛围'),(42,'暴力'),(43,'犯罪'),(44,'砍杀'),(45,'萝莉'),(46,'养成'),(47,'种植');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tagmapper`
--

DROP TABLE IF EXISTS `tagmapper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tagmapper` (
  `game` int NOT NULL COMMENT '游戏ID',
  `tag` int NOT NULL COMMENT '标签ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏-标签映射表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tagmapper`
--

LOCK TABLES `tagmapper` WRITE;
/*!40000 ALTER TABLE `tagmapper` DISABLE KEYS */;
INSERT INTO `tagmapper` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(2,6),(2,2),(2,7),(2,8),(2,9),(2,45),(2,46),(3,10),(3,2),(4,11),(4,10),(4,2),(4,12),(4,13),(5,9),(5,14),(5,1),(5,15),(5,45),(5,46),(6,16),(6,17),(6,13),(6,19),(6,10),(7,20),(7,21),(7,1),(7,13),(8,8),(8,1),(8,22),(8,23),(9,24),(9,25),(9,26),(9,13),(10,10),(10,26),(10,27),(10,2),(10,28),(11,29),(11,18),(11,10),(11,30),(12,26),(12,27),(12,18),(12,10),(12,29),(13,31),(13,1),(13,32),(13,4),(13,34),(14,7),(14,14),(14,10),(15,21),(15,27),(15,18),(16,7),(16,18),(16,8),(17,12),(17,10),(17,11),(17,26),(17,27),(17,33),(18,4),(18,34),(18,1),(18,10),(18,18),(19,35),(19,36),(19,10),(19,9),(19,37),(19,41),(19,44),(20,10),(20,7),(20,18),(20,27),(20,42),(20,43),(20,44),(21,41),(21,24),(21,25),(22,2),(22,4),(22,8),(22,47),(23,37),(23,1),(23,31),(23,18),(24,41),(24,38),(24,8),(24,25),(25,10),(25,35),(25,36),(25,12),(26,18),(26,27),(26,37),(26,42),(26,43),(26,44),(27,1),(27,7),(27,8),(27,47),(28,18),(28,21),(28,27),(28,44),(29,41),(29,37),(30,8),(30,7),(30,12),(30,10),(31,40),(31,18),(31,33),(31,42);
/*!40000 ALTER TABLE `tagmapper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `uid` int NOT NULL COMMENT '用户ID',
  `token` varchar(36) NOT NULL COMMENT 'token',
  `expired_time` timestamp NOT NULL COMMENT '过期时间',
  `ip` varchar(15) NOT NULL DEFAULT '' COMMENT '访问者IP',
  `device` varchar(150) NOT NULL DEFAULT '' COMMENT '登录的设备',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
  `stat` tinyint NOT NULL DEFAULT '0' COMMENT '0表示正常，1表示已过期',
  UNIQUE KEY `token_index` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码(加盐并加密)',
  `nickname` varchar(50) NOT NULL COMMENT '昵称',
  `email` varchar(50) NOT NULL COMMENT '注册邮箱',
  `phone` bigint DEFAULT NULL COMMENT '手机号码',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `stat` tinyint NOT NULL DEFAULT '0' COMMENT '用户状态，0为正常，1为未验证，2为受限，3为删除',
  `introduction` varchar(45) NOT NULL DEFAULT '这个人很懒，没有什么~~' COMMENT '用户简介',
  `gamenum` int NOT NULL DEFAULT '0' COMMENT '拥有游戏数量',
  `playtime` bigint NOT NULL DEFAULT '0' COMMENT '游戏总时间',
  `userimage` varchar(45) NOT NULL DEFAULT '默认路径',
  PRIMARY KEY (`id`),
  KEY `name` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'caisulai','123456','caicaizi','1234567@qq.com',13572898746,'2021-12-14 15:57:10','2021-12-14 15:57:10',0,'一只小菜菜',100,114514,'默认路径');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_games`
--

DROP TABLE IF EXISTS `user_games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_games` (
  `userid` int NOT NULL,
  `gameid` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='玩家所拥有的游戏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_games`
--

LOCK TABLES `user_games` WRITE;
/*!40000 ALTER TABLE `user_games` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_games` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-14 23:58:02
