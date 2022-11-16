package br.edu.unifei.ecot13.worlds;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.unifei.ecot13.worlds.enumeration.GroupEnum;
import br.edu.unifei.ecot13.worlds.enumeration.LeagueEnum;
import br.edu.unifei.ecot13.worlds.enumeration.RoleEnum;
import br.edu.unifei.ecot13.worlds.enumeration.SideEnum;
import br.edu.unifei.ecot13.worlds.enumeration.SummonerSpellEnum;

public class AppInsert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lolPU");
		EntityManager em = emf.createEntityManager();
		
		

		League lck = new League();
		lck.setLeagueName(LeagueEnum.LCK);
		lck.setRegion("Shouth Korea");

		League lpl = new League();
		lpl.setLeagueName(LeagueEnum.LPL);
		lpl.setRegion("China");

		League lcs = new League();
		lcs.setLeagueName(LeagueEnum.LCS);
		lcs.setRegion("North America");
		
		League lec = new League();
		lec.setLeagueName(LeagueEnum.LEC);
		lec.setRegion("Europe");

		Organization t1 = new Organization();
		t1.setName("T1");
		t1.setShortname("T1");
		t1.setLeague(lck);

		Organization edg = new Organization();
		edg.setName("Edward Gaming Hycan");
		edg.setShortname("EDG");
		edg.setLeague(lpl);

		Organization fnc = new Organization();
		fnc.setName("Fnatic");
		fnc.setShortname("FNC");
		fnc.setLeague(lec);
		

		Organization c9 = new Organization();
		c9.setName("Cloud 9");
		c9.setShortname("C9");
		c9.setLeague(lcs);
		

		Player faker = new Player();
		faker.setName("SANGHYEOK LEE");
		faker.setNickname("Faker");
		faker.setRole(RoleEnum.MID);
		t1.getMembers().add(faker);
		

		Player oner = new Player();
		oner.setName("HYUNJUN MUN");
		oner.setNickname("Oner");
		oner.setRole(RoleEnum.JUNGLE);
		t1.getMembers().add(oner);
		

		Player gumayusi = new Player();
		gumayusi.setName("MINHYUNG LEE");
		gumayusi.setNickname("Gumayusi");
		gumayusi.setRole(RoleEnum.BOTTOM);
		t1.getMembers().add(gumayusi);
		

		Player keria = new Player();
		keria.setName("MINSEOK RYU");
		keria.setNickname("Keria");
		keria.setRole(RoleEnum.SUPPORT);
		t1.getMembers().add(keria);
		

		Player zeus = new Player();
		zeus.setName("WOOJE CHOI");
		zeus.setNickname("Zeus");
		zeus.setRole(RoleEnum.TOP);
		t1.getMembers().add(zeus);
		
		
		Coach bengi = new Coach();
		bengi.setName("Seong-woong");
		bengi.setNickname("Bengi");
		bengi.setMainCoach(true);
		t1.getMembers().add(bengi);
		
		
		

		Player meiko = new Player();
		meiko.setName("YE TIAN");
		meiko.setNickname("Meiko");
		meiko.setRole(RoleEnum.SUPPORT);
		edg.getMembers().add(meiko);
		

		Player scout = new Player();
		scout.setName("YECHAN LEE");
		scout.setNickname("Scout");
		scout.setRole(RoleEnum.MID);
		edg.getMembers().add(scout);
		
		
		Player jiejie = new Player();
		jiejie.setName("LI-JIE ZHAO");
		jiejie.setNickname("JieJie");
		jiejie.setRole(RoleEnum.JUNGLE);
		edg.getMembers().add(jiejie);
		
		
		Player viper = new Player();
		viper.setName("DOHYEON PARK");
		viper.setNickname("Viper");
		viper.setRole(RoleEnum.BOTTOM);
		edg.getMembers().add(viper);
		
		
		Player flandre = new Player();
		flandre.setName("XUAN-JUN LI");
		flandre.setNickname("Flandre");
		flandre.setRole(RoleEnum.TOP);
		edg.getMembers().add(flandre);
		
		
		Coach maokai = new Coach();
		maokai.setName("Yang Jisong");
		maokai.setNickname("Maokai");
		maokai.setMainCoach(true);
		edg.getMembers().add(maokai);
		
		
		GroupStage groupA = new GroupStage();
		groupA.setGroupeName(GroupEnum.A);
		groupA.setOrg1(t1);
		groupA.setOrg2(edg);
		groupA.setOrg3(fnc);
		groupA.setOrg4(c9);
		
		SummonerSpell flash = new SummonerSpell(SummonerSpellEnum.FLASH,300);		
		SummonerSpell teleport = new SummonerSpell(SummonerSpellEnum.TELEPORT, 240);		
		SummonerSpell smite = new SummonerSpell(SummonerSpellEnum.SMITE, 15);		
		SummonerSpell heal = new SummonerSpell(SummonerSpellEnum.HEAL, 240);		
		SummonerSpell exaust = new SummonerSpell(SummonerSpellEnum.EXAUST, 210);		
		SummonerSpell cleanse = new SummonerSpell(SummonerSpellEnum.CLEANSE, 210);		
		
		Draft d1 = new Draft();
		d1.setCoach(maokai);
		d1.setSide(SideEnum.RED);
		d1.setBan1(new Ban(1, new Champion("Azir")));
		d1.setBan2(new Ban(3, new Champion("Aatrox")));
		d1.setBan3(new Ban(5, new Champion("Poppy")));
		d1.setBan4(null);
		d1.setBan5(null);
		d1.setPick1(new Pick(1, "Classica", flash, teleport, flandre, new Champion("Maoakai")));
		d1.setPick2(new Pick(4, "Classica", flash, smite, jiejie, new Champion("Graves")));
		d1.setPick3(new Pick(5, "Classica", flash, teleport, scout, new Champion("Lissandra")));
		d1.setPick4(new Pick(8, "Classica", flash, heal, viper, new Champion("Aphelios")));
		d1.setPick5(new Pick(9, "Classica", flash, exaust, meiko, new Champion("Tresh")));
						
		Draft d2 = new Draft();
		d2.setCoach(bengi);
		d2.setSide(SideEnum.BLUE);
		d2.setBan1(new Ban(2, new Champion("Viego")));
		d2.setBan2(new Ban(4, new Champion("Akali")));
		d2.setBan3(new Ban(6, new Champion("Fiora")));
		d2.setBan4(null);
		d2.setBan5(null);
		d2.setPick1(new Pick(2, "Classica", flash, teleport, zeus, new Champion("Gangplank")));
		d2.setPick2(new Pick(3, "Classica", flash, smite, oner, new Champion("Sejuani")));
		d2.setPick3(new Pick(6, "Classica", flash, teleport, faker, new Champion("Viktor")));
		d2.setPick4(new Pick(7, "Classica", flash, cleanse, gumayusi, new Champion("Kalista")));
		d2.setPick5(new Pick(10, "Classica", flash, exaust, keria, new Champion("Soraka")));
		
		Game game = new Game();
		game.setDraft1(d1);
		game.setDraft2(d2);
		game.setOrg1(edg);
		game.setOrg2(t1);
		
		Channel riot = new Channel();
		riot.setPlatform("Twitch");
		riot.setUrl("https://www.twitch.tv/riotgames");
		
		Broadcast broadcast = new Broadcast();
		broadcast.setLanguage("English");
		broadcast.getGames().add(game);
		
		groupA.getGames().add(game);
		
		em.getTransaction().begin();
		//Leagues
		em.persist(lck);
		em.persist(lcs);
		em.persist(lpl);
		em.persist(lec);
		
		//Members
		em.persist(maokai);
		em.persist(flandre);
		em.persist(jiejie);
		em.persist(scout);
		em.persist(viper);
		em.persist(meiko);
		em.persist(bengi);
		em.persist(zeus);
		em.persist(oner);
		em.persist(faker);
		em.persist(gumayusi);
		em.persist(keria);
		
		//Organizations
		em.persist(t1);
		em.persist(edg);
		em.persist(fnc);
		em.persist(c9);
		
		//SummonnerSpells
		em.persist(flash);
		em.persist(teleport);
		em.persist(smite);
		em.persist(heal);
		em.persist(exaust);
		em.persist(cleanse);
		
		//Drafts
		em.persist(d1);
		em.persist(d2);
		
		//Bans
		em.persist(d1.getBan1());
		em.persist(d1.getBan2());
		em.persist(d1.getBan3());
		em.persist(d2.getBan1());
		em.persist(d2.getBan2());
		em.persist(d2.getBan3());
		
		//Picks
		em.persist(d1.getPick1());
		em.persist(d1.getPick2());
		em.persist(d1.getPick3());
		em.persist(d1.getPick4());
		em.persist(d1.getPick5());
		em.persist(d2.getPick1());
		em.persist(d2.getPick2());
		em.persist(d2.getPick3());
		em.persist(d2.getPick4());
		em.persist(d2.getPick5());
		
		//Champions
		em.persist(d1.getBan1().getChampion());
		em.persist(d1.getBan2().getChampion());
		em.persist(d1.getBan3().getChampion());
		em.persist(d1.getPick1().getChampion());
		em.persist(d1.getPick2().getChampion());
		em.persist(d1.getPick3().getChampion());
		em.persist(d1.getPick4().getChampion());
		em.persist(d1.getPick5().getChampion());
		em.persist(d2.getBan1().getChampion());
		em.persist(d2.getBan2().getChampion());
		em.persist(d2.getBan3().getChampion());
		em.persist(d2.getPick1().getChampion());
		em.persist(d2.getPick2().getChampion());
		em.persist(d2.getPick3().getChampion());
		em.persist(d2.getPick4().getChampion());
		em.persist(d2.getPick5().getChampion());
		
		//Games
		em.persist(game);
		
		//Channels
		em.persist(riot);
		
		//Broadcasts
		em.persist(broadcast);
		
		//Groups
		em.persist(groupA);
		

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
