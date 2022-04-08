package com.edu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "population")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Document(indexName = "pop", type="population")
public class Population {
	
	/*1.根据excel表定义好实体类Population
	 *2.创建处理类，处理Excel表格，把表格数据一条一条转化成
	 *Population实体对象，添加到List里
	 *3.创建一个PopulationDAO,参考TestUserDAO,最后把这个list
	 *存储到数据库中(JPA的.saveAll(list)方法)
	 *4.写一个PopulationController,根据id，查询到这条json数据(测试工作)
	 *
	 *
	 *
	 *
	 */
	//col=7
	@Id
	private String id;//
	
	//col=8
	@Column(length = 20)
	private String city;
	
	//col=9
	@Column(length = 50)
	private String municipalities;
	
	//col=10
	private Long totalPopulation;
	
	//col=11
	private Long totalPopulation0_14;
	
	//col=12
	private Long totalPopulation15_64;
	
	//col=13
	private Long totalPopulation65AndOver;
	
	//col=14
	private Long foreignersTotal;
	
	//col=15
	private String denselyInhabitedDistrictsPopulation;
	
	//col=16
	private Long liveBirths;
	
	//col=17
	private Long death;
	
	//col=18
	private Long numberOfIn_migrantsFromOtherMunicipalities;
	
	//col=19
	private Long numberOfOut_migrantsFromOtherMunicipalities;
	
	//col=20
	private Long dayTimePopulation;
	
	//col=21
	private Long numberOfHouseholds_Total;
	
	//col=22
	private Long numberOfPrivateHouseholds;
	
	//col=23
	private Long nuclearFamilies;
	
	//col=24
	private Long one_personHouseholds;
	
	//col=25
	private Long numberOfNuclearFamiliesWithHouseholdMembers65AndOver;
	
	//col=26
	private Long numberOfAged_coupleHouseholdsOnlyAgedCouple;
	
	//col=27
	private Long numberOfAged_single_personHouseholdsAged65AndOver;
	
	//col=28
	private Long marriages;
	
	//col=29
	private Long divorces;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMunicipalities() {
		return municipalities;
	}

	public void setMunicipalities(String municipalities) {
		this.municipalities = municipalities;
	}

	public Long getTotalPopulation() {
		return totalPopulation;
	}

	public void setTotalPopulation(Long totalPopulation) {
		this.totalPopulation = totalPopulation;
	}

	public Long getTotalPopulation0_14() {
		return totalPopulation0_14;
	}

	public void setTotalPopulation0_14(Long totalPopulation0_14) {
		this.totalPopulation0_14 = totalPopulation0_14;
	}

	public Long getTotalPopulation15_64() {
		return totalPopulation15_64;
	}

	public void setTotalPopulation15_64(Long totalPopulation15_64) {
		this.totalPopulation15_64 = totalPopulation15_64;
	}

	public Long getTotalPopulation65AndOver() {
		return totalPopulation65AndOver;
	}

	public void setTotalPopulation65AndOver(Long totalPopulation65AndOver) {
		this.totalPopulation65AndOver = totalPopulation65AndOver;
	}

	public Long getForeignersTotal() {
		return foreignersTotal;
	}

	public void setForeignersTotal(Long foreignersTotal) {
		this.foreignersTotal = foreignersTotal;
	}

	public String getDenselyInhabitedDistrictsPopulation() {
		return denselyInhabitedDistrictsPopulation;
	}

	public void setDenselyInhabitedDistrictsPopulation(String denselyInhabitedDistrictsPopulation) {
		this.denselyInhabitedDistrictsPopulation = denselyInhabitedDistrictsPopulation;
	}

	public Long getLiveBirths() {
		return liveBirths;
	}

	public void setLiveBirths(Long liveBirths) {
		this.liveBirths = liveBirths;
	}

	public Long getDeath() {
		return death;
	}

	public void setDeath(Long death) {
		this.death = death;
	}

	public Long getNumberOfIn_migrantsFromOtherMunicipalities() {
		return numberOfIn_migrantsFromOtherMunicipalities;
	}

	public void setNumberOfIn_migrantsFromOtherMunicipalities(
			Long numberOfIn_migrantsFromOtherMunicipalities) {
		this.numberOfIn_migrantsFromOtherMunicipalities = numberOfIn_migrantsFromOtherMunicipalities;
	}

	public Long getNumberOfOut_migrantsFromOtherMunicipalities() {
		return numberOfOut_migrantsFromOtherMunicipalities;
	}

	public void setNumberOfOut_migrantsFromOtherMunicipalities(
			Long numberOfOut_migrantsFromOtherMunicipalities) {
		this.numberOfOut_migrantsFromOtherMunicipalities = numberOfOut_migrantsFromOtherMunicipalities;
	}

	public Long getDayTimePopulation() {
		return dayTimePopulation;
	}

	public void setDayTimePopulation(Long dayTimePopulation) {
		this.dayTimePopulation = dayTimePopulation;
	}

	public Long getNumberOfHouseholds_Total() {
		return numberOfHouseholds_Total;
	}

	public void setNumberOfHouseholds_Total(Long numberOfHouseholds_Total) {
		this.numberOfHouseholds_Total = numberOfHouseholds_Total;
	}

	public Long getNumberOfPrivateHouseholds() {
		return numberOfPrivateHouseholds;
	}

	public void setNumberOfPrivateHouseholds(Long numberOfPrivateHouseholds) {
		this.numberOfPrivateHouseholds = numberOfPrivateHouseholds;
	}

	public Long getNuclearFamilies() {
		return nuclearFamilies;
	}

	public void setNuclearFamilies(Long nuclearFamilies) {
		this.nuclearFamilies = nuclearFamilies;
	}

	public Long getOne_personHouseholds() {
		return one_personHouseholds;
	}

	public void setOne_personHouseholds(Long one_personHouseholds) {
		this.one_personHouseholds = one_personHouseholds;
	}

	public Long getNumberOfNuclearFamiliesWithHouseholdMembers65AndOver() {
		return numberOfNuclearFamiliesWithHouseholdMembers65AndOver;
	}

	public void setNumberOfNuclearFamiliesWithHouseholdMembers65AndOver(
			Long numberOfNuclearFamiliesWithHouseholdMembers65AndOver) {
		this.numberOfNuclearFamiliesWithHouseholdMembers65AndOver = numberOfNuclearFamiliesWithHouseholdMembers65AndOver;
	}

	public Population(String id, String city, String municipalities, Long totalPopulation, Long totalPopulation0_14,
			Long totalPopulation15_64, Long totalPopulation65AndOver, Long foreignersTotal,
			String denselyInhabitedDistrictsPopulation, Long liveBirths, Long death,
			Long numberOfIn_migrantsFromOtherMunicipalities, Long numberOfOut_migrantsFromOtherMunicipalities,
			Long dayTimePopulation, Long numberOfHouseholds_Total, Long numberOfPrivateHouseholds, Long nuclearFamilies,
			Long one_personHouseholds, Long numberOfNuclearFamiliesWithHouseholdMembers65AndOver,
			Long numberOfAged_coupleHouseholdsOnlyAgedCouple, Long numberOfAged_single_personHouseholdsAged65AndOver,
			Long marriages, Long divorces) {
		super();
		this.id = id;
		this.city = city;
		this.municipalities = municipalities;
		this.totalPopulation = totalPopulation;
		this.totalPopulation0_14 = totalPopulation0_14;
		this.totalPopulation15_64 = totalPopulation15_64;
		this.totalPopulation65AndOver = totalPopulation65AndOver;
		this.foreignersTotal = foreignersTotal;
		this.denselyInhabitedDistrictsPopulation = denselyInhabitedDistrictsPopulation;
		this.liveBirths = liveBirths;
		this.death = death;
		this.numberOfIn_migrantsFromOtherMunicipalities = numberOfIn_migrantsFromOtherMunicipalities;
		this.numberOfOut_migrantsFromOtherMunicipalities = numberOfOut_migrantsFromOtherMunicipalities;
		this.dayTimePopulation = dayTimePopulation;
		this.numberOfHouseholds_Total = numberOfHouseholds_Total;
		this.numberOfPrivateHouseholds = numberOfPrivateHouseholds;
		this.nuclearFamilies = nuclearFamilies;
		this.one_personHouseholds = one_personHouseholds;
		this.numberOfNuclearFamiliesWithHouseholdMembers65AndOver = numberOfNuclearFamiliesWithHouseholdMembers65AndOver;
		this.numberOfAged_coupleHouseholdsOnlyAgedCouple = numberOfAged_coupleHouseholdsOnlyAgedCouple;
		this.numberOfAged_single_personHouseholdsAged65AndOver = numberOfAged_single_personHouseholdsAged65AndOver;
		this.marriages = marriages;
		this.divorces = divorces;
	}
	
	public Population(){
		
	}

	public Long getNumberOfAged_coupleHouseholdsOnlyAgedCouple() {
		return numberOfAged_coupleHouseholdsOnlyAgedCouple;
	}

	public void setNumberOfAged_coupleHouseholdsOnlyAgedCouple(Long numberOfAged_coupleHouseholdsOnlyAgedCouple) {
		this.numberOfAged_coupleHouseholdsOnlyAgedCouple = numberOfAged_coupleHouseholdsOnlyAgedCouple;
	}

	public Long getNumberOfAged_single_personHouseholdsAged65AndOver() {
		return numberOfAged_single_personHouseholdsAged65AndOver;
	}

	public void setNumberOfAged_single_personHouseholdsAged65AndOver(
			Long numberOfAged_single_personHouseholdsAged65AndOver) {
		this.numberOfAged_single_personHouseholdsAged65AndOver = numberOfAged_single_personHouseholdsAged65AndOver;
	}

	public Long getMarriages() {
		return marriages;
	}

	public void setMarriages(Long marriages) {
		this.marriages = marriages;
	}

	public Long getDivorces() {
		return divorces;
	}

	public void setDivorces(Long divorces) {
		this.divorces = divorces;
	}

	
	
}
