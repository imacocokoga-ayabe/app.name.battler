package com.e.app_namebattler.view.party.job

import com.e.app_namebattler.view.party.player.Player
import com.e.app_namebattler.view.party.skill.Skill
import com.e.app_namebattler.view.view.music.SoundData

class JobFighter(name: String) : Player(name) {

    constructor(name: String, job: String, hp: Int, mp: Int, str: Int, def: Int, agi: Int, luck: Int) : this(name){
        makePlayer(name, job, hp, mp, str, def, agi, luck)
    }

    override fun makeCharacter(name: String) {

        // 戦士のパラメータを名前から生成する
        this.job = JobData.FIGHTER.getJobName()
        this.hp = getNumber(200) + 100 // 100-300
        this.mp = getNumber(0) // 0
        this.str = getNumber(70) + 30 // 30-100
        this.def = getNumber(70) + 30 // 30-100
        this.luck = getNumber(99) + 1 // 1-100
        this.agi = getNumber(49) + 1 // 1-50
    }

    override fun normalAttack(defender: Player): StringBuilder {

        log.clear()

        if (this.isParalysis) {// 麻痺している場合

            log.append("${this.getName()}は麻痺で動けない！！\n")
            knockedDownCheck(defender)

        } else {// 麻痺していない場合

            log.append("${this.getName()}の攻撃！\n${this.getName()}は剣で斬りつけた！\n")
            setAttackSoundEffect(SoundData.S_SWORD01.getSoundNumber())
            damage = calcDamage(defender) // 与えるダメージを求める
            damageProcess(defender, damage)
            knockedDownCheck(defender)

        }
        return log
    }

    override fun skillAttack(defender: Player): StringBuilder { // スキル攻撃処理

        log.clear()

        if (this.isParalysis) {// 麻痺している場合

            log.append("${this.getName()}は麻痺で動けない！！\n")
            knockedDownCheck(defender)

        } else {// 麻痺していない場合

            if ((1..100).random() < Skill.ASSAULT.getInvocationRate()) { // 確率で発動
                log.append("${this.getName()}の${Skill.ASSAULT.getSkillName()}！\n")
                damage = calcDamage(defender) // 与えるダメージを求める
                damage *= Skill.ASSAULT.getDamageRate() // ダメージ2倍
                setAttackSoundEffect(SoundData.S_SWORD02.getSoundNumber())
                super.damageProcess(defender, damage) // ダメージ処理

            } else {
                log.append("${this.getName()}の${Skill.ASSAULT.getSkillName()}はかわされた！！\n")
                setAttackSoundEffect(SoundData.S_SWORD02_AIR_SHOT.getSoundNumber())
            }
            knockedDownCheck(defender)
        }
        return log
    }
}