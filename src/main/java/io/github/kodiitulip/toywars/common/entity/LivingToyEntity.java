package io.github.kodiitulip.toywars.common.entity;

import io.github.kodiitulip.toywars.common.init.ToywarsEntities;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LivingToyEntity extends AnimalEntity {
	public final AnimationState idleAnimationState = new AnimationState();
	private int idleTimeout = 0;

	public LivingToyEntity(EntityType<? extends AnimalEntity> entityType,
						   World world) {
		super(entityType, world);
	}

	@Override
	protected void updateLimbs(float limbDistance) {
		float f = this.getPose() == EntityPose.STANDING ? Math.min(limbDistance * 6.0f, 1.0f) : 0.0f;
		this.limbData.updateLimbs(f, 0.2f);
	}

	private void setupAnimationStates() {
		if (this.idleTimeout <= 0) {
			this.idleTimeout = this.random.nextInt(40) + 80;
			this.idleAnimationState.start(this.age);
		} else {
			--this.idleTimeout;
		}
	}

	@Override
	public void tick() {
		super.tick();
		if (this.getWorld().isClient) {
			setupAnimationStates();
		}
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new SwimGoal(this));
		this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0));
		this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
		this.goalSelector.add(3, new TemptGoal(this, 1.25, Ingredient.ofItems(Items.CLAY_BALL), false));
		this.goalSelector.add(4, new FollowParentGoal(this, 1.25));
		this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
		this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.add(7, new LookAroundGoal(this));
	}

	public static DefaultAttributeContainer.Builder createLivingToyAttributes() {
		return MobEntity.createAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
			.add(EntityAttributes.GENERIC_ARMOR, 0.5f)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2);
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.isOf(Items.CLAY_BALL);
	}


	@Override
	protected float getSoundVolume() {
		return 0.4f;
	}

	@Nullable
	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return ToywarsEntities.LIVINGTOY.create(world);
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_GRAVEL_BREAK;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.BLOCK_GRAVEL_HIT;
	}
}
